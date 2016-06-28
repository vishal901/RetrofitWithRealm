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



    // key static levi
    public  void SavePref(Context cntx, String key, String value) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();

        //used this

//        AllStaticMethod.SavePref(this, AppConfing.Level1, "vishal");
//        AllStaticMethod.SavePref(this, AppConfing.Level2, "rakshit");
//        AllStaticMethod.SavePref(this, AppConfing.Level3, "dashrath");
//        AllStaticMethod.SavePref(this, AppConfing.Level4, "harsh");
    }

    //key satatic vari levi set karaveli
    public  String LoadPref(Context cntx, String key) {

        return prefs.getString(key, null);

        //used this

//        String a = AllStaticMethod.LoadPref(this, AppConfing.Level1);
//        String b = AllStaticMethod.LoadPref(this, AppConfing.Level2);
//        String c = AllStaticMethod.LoadPref(this, AppConfing.Level3);
//        String d = AllStaticMethod.LoadPref(this, AppConfing.Level4);
    }

}