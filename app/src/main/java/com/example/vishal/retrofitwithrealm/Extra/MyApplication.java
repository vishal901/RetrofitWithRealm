package com.example.vishal.retrofitwithrealm.Extra;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by vishal on 28/06/2016.
 */
public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();

    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        RealmConfiguration configuration = new RealmConfiguration.Builder(this)
                .name("MyDatabase.realm")
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(configuration);

    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public void showLog(String TAG, String msg) {
        Log.e(TAG, msg);
    }
}
