cordova-plugin-roaming
======================
To install this plugin, follow the [Command-line Interface Guide](http://cordova.apache.org/docs/en/edge/guide_cli_index.md.html#The%20Command-line%20Interface).

If you are not using the Cordova Command-line Interface, follow [Using Plugman to Manage Plugins](http://cordova.apache.org/docs/en/edge/guide_plugin_ref_plugman.md.html).

Exposes 1 methods:

- __get__: returns NetworkInfo.isRoaming as a bool

Each method takes two arguments, success and error functions.

Usage examples:

    window.plugins.roaming.get(
      function(roaming) {
        console.log("roaming status: " + roaming);
      },
      function() {
        console.log("error loading roaming status");
      }
    );
