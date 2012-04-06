 // Wait for PhoneGap to load
    //
    document.addEventListener("deviceready", onDeviceReady, false);

    // PhoneGap is ready
    //
    function onDeviceReady() {
        // Empty
    }

    // alert dialog dismissed
    function alertDismissed() {
        // do something
    }

    // Show a custom alert
    //
    function showAlert() {
        navigator.notification.alert(
            "Nothing...this app doesn't make money yet!",  // message
            alertDismissed,         // callback
            'Opps!',            // title
            'Done'                  // buttonName
        );
    }
