// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.media;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

/**
 * This class implements a factory of Android Video Capture objects for Chrome.
 * Cameras are identified by |id|. Video Capture objects allocated via
 * createVideoCapture() are explicitly owned by the caller. ChromiumCameraInfo
 * is an internal class with some static methods needed from the rest of the
 * class to manipulate the |id|s of devices.
 **/
@JNINamespace("media")
@SuppressWarnings("deprecation")
class VideoCaptureFactory {
    // Internal class to encapsulate camera device id manipulations.
    static class ChromiumCameraInfo {
        private static int sNumberOfSystemCameras = -1;
        private static final String TAG = "cr.media";

        private static int getNumberOfCameras(Context appContext) {
            if (sNumberOfSystemCameras == -1) {
                // getNumberOfCameras() would not fail due to lack of permission, but the
                // following operations on camera would. "No permission" isn't a fatal
                // error in WebView, specially for those applications which have no purpose
                // to use a camera, but "load page" requires it. So, output a warning log
                // and carry on pretending the system has no camera(s).  This optimization
                // applies only to pre-M on Android because that is when runtime permissions
                // were introduced.
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                        && appContext.getPackageManager().checkPermission(
                                   Manifest.permission.CAMERA, appContext.getPackageName())
                                != PackageManager.PERMISSION_GRANTED) {
                    sNumberOfSystemCameras = 0;
                    Log.w(TAG, "Missing android.permission.CAMERA permission, "
                                    + "no system camera available.");
                } else {
                    if (isLReleaseOrLater()) {
                        sNumberOfSystemCameras = VideoCaptureCamera2.getNumberOfCameras(appContext);
                    } else {
                        sNumberOfSystemCameras = VideoCaptureCamera.getNumberOfCameras();
                    }
                }
            }
            return sNumberOfSystemCameras;
        }
    }

    private static boolean isLReleaseOrLater() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    @CalledByNative
    static boolean isLegacyOrDeprecatedDevice(Context context, int id) {
        return !isLReleaseOrLater() || VideoCaptureCamera2.isLegacyDevice(context, id);
    }

    // Factory methods.
    @CalledByNative
    static VideoCapture createVideoCapture(
            Context context, int id, long nativeVideoCaptureDeviceAndroid) {
        if (isLReleaseOrLater() && !VideoCaptureCamera2.isLegacyDevice(context, id)) {
            return new VideoCaptureCamera2(context, id, nativeVideoCaptureDeviceAndroid);
        }
        return new VideoCaptureCamera(context, id, nativeVideoCaptureDeviceAndroid);
    }

    @CalledByNative
    static int getNumberOfCameras(Context appContext) {
        return ChromiumCameraInfo.getNumberOfCameras(appContext);
    }

    @CalledByNative
    static int getCaptureApiType(int id, Context appContext) {
        if (isLReleaseOrLater()) {
            return VideoCaptureCamera2.getCaptureApiType(id, appContext);
        }
        return VideoCaptureCamera.getCaptureApiType(id);
    }

    @CalledByNative
    static String getDeviceName(int id, Context appContext) {
        if (isLReleaseOrLater() && !VideoCaptureCamera2.isLegacyDevice(appContext, id)) {
            return VideoCaptureCamera2.getName(id, appContext);
        }
        return VideoCaptureCamera.getName(id);
    }

    @CalledByNative
    static VideoCaptureFormat[] getDeviceSupportedFormats(Context appContext, int id) {
        if (isLReleaseOrLater() && !VideoCaptureCamera2.isLegacyDevice(appContext, id)) {
            return VideoCaptureCamera2.getDeviceSupportedFormats(appContext, id);
        }
        return VideoCaptureCamera.getDeviceSupportedFormats(id);
    }

    @CalledByNative
    static int getCaptureFormatWidth(VideoCaptureFormat format) {
        return format.getWidth();
    }

    @CalledByNative
    static int getCaptureFormatHeight(VideoCaptureFormat format) {
        return format.getHeight();
    }

    @CalledByNative
    static int getCaptureFormatFramerate(VideoCaptureFormat format) {
        return format.getFramerate();
    }

    @CalledByNative
    static int getCaptureFormatPixelFormat(VideoCaptureFormat format) {
        return format.getPixelFormat();
    }
}