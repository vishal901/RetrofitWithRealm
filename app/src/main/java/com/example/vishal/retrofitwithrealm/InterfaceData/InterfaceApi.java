package com.example.vishal.retrofitwithrealm.InterfaceData;

import com.example.vishal.retrofitwithrealm.ResponseData.RegData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by vishal on 28/06/2016.
 */
public interface InterfaceApi {


    @FormUrlEncoded
    @POST("register")
    Call<RegData> reg_method(@FieldMap Map<String,String> stringMap);

    @FormUrlEncoded
    @POST("register")
    Call<RegData> reg_method_f(@Field("firstName") String fname,
                               @Field("lastName") String sdd,
                               @Field("email") String fdsname,
                               @Field("password") String fnadsme,
                               @Field("phone") String s);
}
