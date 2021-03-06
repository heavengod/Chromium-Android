
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/WebKit/public/platform/modules/bluetooth/web_bluetooth.mojom
//

package org.chromium.blink.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public interface WebBluetoothService extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends WebBluetoothService, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<WebBluetoothService, WebBluetoothService.Proxy> MANAGER = WebBluetoothService_Internal.MANAGER;


    void requestDevice(
WebBluetoothRequestDeviceOptions options, 
RequestDeviceResponse callback);

    interface RequestDeviceResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, WebBluetoothDevice> { }



    void remoteServerConnect(
WebBluetoothDeviceId deviceId, org.chromium.mojo.bindings.AssociatedInterfaceNotSupported client, 
RemoteServerConnectResponse callback);

    interface RemoteServerConnectResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }



    void remoteServerDisconnect(
WebBluetoothDeviceId deviceId);



    void remoteServerGetPrimaryServices(
WebBluetoothDeviceId deviceId, int quantity, org.chromium.bluetooth.mojom.Uuid servicesUuid, 
RemoteServerGetPrimaryServicesResponse callback);

    interface RemoteServerGetPrimaryServicesResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, WebBluetoothRemoteGattService[]> { }



    void remoteServiceGetCharacteristics(
String serviceInstanceId, int quantity, org.chromium.bluetooth.mojom.Uuid characteristicsUuid, 
RemoteServiceGetCharacteristicsResponse callback);

    interface RemoteServiceGetCharacteristicsResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, WebBluetoothRemoteGattCharacteristic[]> { }



    void remoteCharacteristicReadValue(
String characteristicInstanceId, 
RemoteCharacteristicReadValueResponse callback);

    interface RemoteCharacteristicReadValueResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, byte[]> { }



    void remoteCharacteristicWriteValue(
String characteristicInstanceId, byte[] value, 
RemoteCharacteristicWriteValueResponse callback);

    interface RemoteCharacteristicWriteValueResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }



    void remoteCharacteristicStartNotifications(
String characteristicInstanceId, org.chromium.mojo.bindings.AssociatedInterfaceNotSupported client, 
RemoteCharacteristicStartNotificationsResponse callback);

    interface RemoteCharacteristicStartNotificationsResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }



    void remoteCharacteristicStopNotifications(
String characteristicInstanceId, 
RemoteCharacteristicStopNotificationsResponse callback);

    interface RemoteCharacteristicStopNotificationsResponse extends org.chromium.mojo.bindings.Callbacks.Callback0 { }



    void remoteCharacteristicGetDescriptors(
String characteristicsInstanceId, int quantity, org.chromium.bluetooth.mojom.Uuid descriptorUuid, 
RemoteCharacteristicGetDescriptorsResponse callback);

    interface RemoteCharacteristicGetDescriptorsResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, WebBluetoothRemoteGattDescriptor[]> { }



    void remoteDescriptorReadValue(
String descriptorInstanceId, 
RemoteDescriptorReadValueResponse callback);

    interface RemoteDescriptorReadValueResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, byte[]> { }



    void remoteDescriptorWriteValue(
String descriptorInstanceId, byte[] value, 
RemoteDescriptorWriteValueResponse callback);

    interface RemoteDescriptorWriteValueResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


}
