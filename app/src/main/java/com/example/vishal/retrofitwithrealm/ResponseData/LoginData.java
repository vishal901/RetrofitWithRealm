package com.example.vishal.retrofitwithrealm.ResponseData;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vishal on 28/06/2016.
 */
public class LoginData {
    /**
     * error : false
     * result : {"firstName":"Anc","lastName":"Jdg","email":"vhgg@gmail.com","apiKey":"7affc36cd1fcd18a4d3933285abc1eef","status":1,"phone":"8490833401","verified":0}
     */

    @SerializedName("error")
    private boolean error;
    /**
     * firstName : Anc
     * lastName : Jdg
     * email : vhgg@gmail.com
     * apiKey : 7affc36cd1fcd18a4d3933285abc1eef
     * status : 1
     * phone : 8490833401
     * verified : 0
     */

    @SerializedName("result")
    private ResultBean result;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        @SerializedName("firstName")
        private String firstName;
        @SerializedName("lastName")
        private String lastName;
        @SerializedName("email")
        private String email;
        @SerializedName("apiKey")
        private String apiKey;
        @SerializedName("status")
        private int status;
        @SerializedName("phone")
        private String phone;
        @SerializedName("verified")
        private int verified;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getVerified() {
            return verified;
        }

        public void setVerified(int verified) {
            this.verified = verified;
        }
    }
}
