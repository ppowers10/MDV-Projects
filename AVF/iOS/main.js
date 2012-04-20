// Wait for PhoneGap to load
//
document.addEventListener("deviceready", onDeviceReady, false);

// PhoneGap is ready
//
function onDeviceReady() {
    // Empty
}

//__________________________________________

// alert dialog dismissed
function alertDismissed() {
    // do something
}

// Show a custom alert
//
function showAlert() {
    navigator.notification.alert(
                                 "Alert...check!",  // message
                                 alertDismissed,         // callback
                                 'Alert Works!',            // title
                                 'Done'                  // buttonName
                                 );
}

//__________________________________________

function checkAcc() {
    navigator.accelerometer.getCurrentAcceleration(onSuccess, onError);
}

// onSuccess: Get a snapshot of the current acceleration
//
function onSuccess(acceleration) {
    alert('Acceleration X: ' + acceleration.x + '\n' +
          'Acceleration Y: ' + acceleration.y + '\n' +
          'Acceleration Z: ' + acceleration.z + '\n' +
          'Timestamp: '      + acceleration.timestamp + '\n');
}

// onError: Failed to get the acceleration
//
function onError() {
    alert('onError!');
}

//__________________________________________

function checkConnection() {
    var networkState = navigator.network.connection.type;
    
    var states = {};
    states[Connection.UNKNOWN]  = 'Unknown connection';
    states[Connection.ETHERNET] = 'Ethernet connection';
    states[Connection.WIFI]     = 'WiFi connection';
    states[Connection.CELL_2G]  = 'Cell 2G connection';
    states[Connection.CELL_3G]  = 'Cell 3G connection';
    states[Connection.CELL_4G]  = 'Cell 4G connection';
    states[Connection.NONE]     = 'No network connection';
    
    alert('Connection type: ' + states[networkState]);
}

