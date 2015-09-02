cordova-plugin-roaming
======================
To install this plugin, follow the [Command-line Interface Guide](http://cordova.apache.org/docs/en/edge/guide_cli_index.md.html#The%20Command-line%20Interface).

If you are not using the Cordova Command-line Interface, follow [Using Plugman to Manage Plugins](http://cordova.apache.org/docs/en/edge/guide_plugin_ref_plugman.md.html).

# Exposed methods:

Each method takes two callback functions, a success and an error function.

## 1: __get__ returns NetworkInfo.isRoaming as a bool

Usage example:

    window.plugins.roaming.get(
      function(roaming) {
        console.log("roaming status: " + roaming);
      },
      function() {
        console.log("error loading roaming status");
      }
    );

## 2: __getNetworkRoaming__ returns telephonyManager.isNetworkRoaming() as a bool

More information: 
http://developer.android.com/reference/android/net/NetworkInfo.html#isRoaming()

Usage example:

    window.plugins.roaming.getNetworkRoaming(
        function(roaming) {
          console.log('Network roaming status: ' + roaming);
        },
        function() {
          console.log('Error loading roaming status');
        }
    );
