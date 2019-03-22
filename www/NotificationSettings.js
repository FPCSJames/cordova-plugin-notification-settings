/* eslint-env node */

var exec = require('cordova/exec');

module.exports = {
   launch: function(success, failure) {
      exec(success, failure, 'NotificationSettings', 'launch');
   }
};
