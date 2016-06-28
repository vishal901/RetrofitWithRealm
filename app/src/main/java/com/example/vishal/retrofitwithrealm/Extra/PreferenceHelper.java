/**
 * @author Jenish Khanpara
 */

package com.example.vishal.retrofitwithrealm.Extra;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


public class PreferenceHelper {

    private final String PREFS_IS_CONFIGURE = "isConfigure";
    private SharedPreferences prefs;


    public PreferenceHelper(Context ctx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static PreferenceHelper newInstance(Context ctx) {
        return new PreferenceHelper(ctx);
    }


    public boolean isConfigure() {
        return prefs.getBoolean(PREFS_IS_CONFIGURE, false);
    }

    public void setConfigure(boolean value) {
        prefs.edit().putBoolean(PREFS_IS_CONFIGURE, value).apply();
    }

    public void clearAllPrefs() {
        prefs.edit().clear().apply();
    }

    public void addValue(String apikey) {

        prefs.edit().putString("apikey", apikey).commit();
    }

    public String GetApikey() {

        String apikey = prefs.getString("apikey", "");

        return apikey;
    }

    // key static levi
    public  void SavePref(Activity cntx, String key, String value) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    //key satatic vari levi set karaveli
    public  String LoadPref(Context cntx, String key) {

        return prefs.getString(key, null);
    }

}