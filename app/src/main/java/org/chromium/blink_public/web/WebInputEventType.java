
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../third_party/WebKit/public/platform/WebInputEvent.h

package org.chromium.blink_public.web;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    WebInputEventType.kUndefined, WebInputEventType.kTypeFirst, WebInputEventType.kMouseDown,
    WebInputEventType.kMouseTypeFirst, WebInputEventType.kMouseUp, WebInputEventType.kMouseMove,
    WebInputEventType.kMouseEnter, WebInputEventType.kMouseLeave, WebInputEventType.kContextMenu,
    WebInputEventType.kMouseTypeLast, WebInputEventType.kMouseWheel, WebInputEventType.kRawKeyDown,
    WebInputEventType.kKeyboardTypeFirst, WebInputEventType.kKeyDown, WebInputEventType.kKeyUp,
    WebInputEventType.kChar, WebInputEventType.kKeyboardTypeLast,
    WebInputEventType.kGestureScrollBegin, WebInputEventType.kGestureTypeFirst,
    WebInputEventType.kGestureScrollEnd, WebInputEventType.kGestureScrollUpdate,
    WebInputEventType.kGestureFlingStart, WebInputEventType.kGestureFlingCancel,
    WebInputEventType.kGesturePinchBegin, WebInputEventType.kGesturePinchEnd,
    WebInputEventType.kGesturePinchUpdate, WebInputEventType.kGestureTapDown,
    WebInputEventType.kGestureShowPress, WebInputEventType.kGestureTap,
    WebInputEventType.kGestureTapCancel, WebInputEventType.kGestureLongPress,
    WebInputEventType.kGestureLongTap, WebInputEventType.kGestureTwoFingerTap,
    WebInputEventType.kGestureTapUnconfirmed, WebInputEventType.kGestureDoubleTap,
    WebInputEventType.kGestureTypeLast, WebInputEventType.kTouchStart,
    WebInputEventType.kTouchTypeFirst, WebInputEventType.kTouchMove, WebInputEventType.kTouchEnd,
    WebInputEventType.kTouchCancel, WebInputEventType.kTouchScrollStarted,
    WebInputEventType.kTouchTypeLast, WebInputEventType.kTypeLast
})
@Retention(RetentionPolicy.SOURCE)
public @interface WebInputEventType {
  int kUndefined = -1;
  int kTypeFirst = -1;
  /**
   * WebMouseEvent
   */
  int kMouseDown = 0;
  int kMouseTypeFirst = 0;
  int kMouseUp = 1;
  int kMouseMove = 2;
  int kMouseEnter = 3;
  int kMouseLeave = 4;
  int kContextMenu = 5;
  int kMouseTypeLast = 5;
  /**
   * WebMouseWheelEvent
   */
  int kMouseWheel = 6;
  /**
   * WebKeyboardEvent
   */
  int kRawKeyDown = 7;
  int kKeyboardTypeFirst = 7;
  /**
   * KeyDown is a single event combining RawKeyDown and Char.  If KeyDown is sent for a given
   * keystroke, those two other events will not be sent. Platforms tend to prefer sending in one
   * format (Android uses KeyDown, Windows uses RawKeyDown+Char, for example), but this is a weakly
   * held property as tools like WebDriver/DevTools might still send the other format.
   */
  int kKeyDown = 8;
  int kKeyUp = 9;
  int kChar = 10;
  int kKeyboardTypeLast = 10;
  /**
   * WebGestureEvent - input interpreted semi-semantically, most commonly from touchscreen but also
   * used for touchpad, mousewheel, and gamepad scrolling.
   */
  int kGestureScrollBegin = 11;
  int kGestureTypeFirst = 11;
  int kGestureScrollEnd = 12;
  int kGestureScrollUpdate = 13;
  /**
   * Fling is a high-velocity and quickly released finger movement. FlingStart is sent once and
   * kicks off a scroll animation.
   */
  int kGestureFlingStart = 14;
  int kGestureFlingCancel = 15;
  /**
   * Pinch is two fingers moving closer or farther apart.
   */
  int kGesturePinchBegin = 16;
  int kGesturePinchEnd = 17;
  int kGesturePinchUpdate = 18;
  /**
   * The following types are variations and subevents of single-taps. Sent the moment the user's
   * finger hits the screen.
   */
  int kGestureTapDown = 19;
  /**
   * Sent a short interval later, after it seems the finger is staying in place.  It's used to
   * activate the link highlight ("show the press").
   */
  int kGestureShowPress = 20;
  /**
   * Sent on finger lift for a simple, static, quick finger tap.  This is the "main" event which
   * maps to a synthetic mouse click event.
   */
  int kGestureTap = 21;
  /**
   * Sent when a GestureTapDown didn't turn into any variation of GestureTap (likely it turned into
   * a scroll instead).
   */
  int kGestureTapCancel = 22;
  /**
   * Sent as soon as the long-press timeout fires, while the finger is still down.
   */
  int kGestureLongPress = 23;
  /**
   * Sent when the finger is lifted following a GestureLongPress.
   */
  int kGestureLongTap = 24;
  /**
   * Sent on finger lift when two fingers tapped at the same time without moving.
   */
  int kGestureTwoFingerTap = 25;
  /**
   * A rare event sent in place of GestureTap on desktop pages viewed on an Android phone.  This tap
   * could not yet be resolved into a GestureTap because it may still turn into a GestureDoubleTap.
   */
  int kGestureTapUnconfirmed = 26;
  /**
   * Double-tap is two single-taps spread apart in time, like a double-click. This event is only
   * sent on desktop pages viewed on an Android phone, and is always preceded by
   * GestureTapUnconfirmed.  It's an instruction to Blink to perform a PageScaleAnimation zoom onto
   * the double-tapped content.  (It's treated differently from GestureTap with tapCount=2, which
   * can also happen.)
   */
  int kGestureDoubleTap = 27;
  int kGestureTypeLast = 27;
  /**
   * WebTouchEvent - raw touch pointers not yet classified into gestures.
   */
  int kTouchStart = 28;
  int kTouchTypeFirst = 28;
  int kTouchMove = 29;
  int kTouchEnd = 30;
  int kTouchCancel = 31;
  int kTouchScrollStarted = 32;
  int kTouchTypeLast = 32;
  int kTypeLast = 32;
}
