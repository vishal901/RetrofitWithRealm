package com.example.vishal.retrofitwithrealm.DatabaseData;

import io.realm.RealmObject;

/**
 * Created by vishal on 28/06/2016.
 */
public class regpojo extends RealmObject {

    private String msg;
    private boolean error;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
