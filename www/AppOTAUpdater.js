var exec = require('cordova/exec');

var AppOTAUpdater = {
  downloadAndInstall(url, callback) {
    exec(function () {
      callback(null);
    }, function (err) {
      callback(err);
    }, "AppOTAUpdaterPlugin", "downloadAndInstall", [url]);
  }
};

module.exports = AppOTAUpdater;