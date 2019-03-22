package net.flashpointcs.cordova.notificationsettings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;

public class NotificationSettings extends CordovaPlugin {

   private final String PLUGIN = "NotificationSettings";

   @Override
   public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
      if(action.equals("launch")) {
         openSettings();
         Log.d(PLUGIN, "Launch called.");
         return true;
      } else {
         return false;
      }
   }

   private void openSettings() {

      String packageName = this.cordova.getActivity().getPackageName();
      Context context = this.cordova.getActivity().getApplicationContext();

      // H/T NewDevin et al - https://stackoverflow.com/a/53976393

      try {
         Intent intent = new Intent();
         if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
            intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
         } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", packageName);
            intent.putExtra("app_uid", context.getApplicationInfo().uid);
         } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setData(Uri.parse("package:" + packageName));
         } else {
            return;
         }
         this.cordova.getActivity().startActivity(intent);
      } catch (Exception e) {
         Log.e(PLUGIN, "Exception occurred while trying to launch intent.");
      }

   }

}
