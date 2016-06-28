package com.example.vishal.retrofitwithrealm.ResponseData;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vishal on 28/06/2016.
 */
public class RegData {

    /**
     * error : true
     * message : Sorry, email id already registered
     */

    @SerializedName("error")
    private boolean error;
    @SerializedName("message")
    private String message;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
