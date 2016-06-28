package com.example.vishal.retrofitwithrealm.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vishal.retrofitwithrealm.DatabaseData.regpojo;
import com.example.vishal.retrofitwithrealm.Extra.MyApplication;
import com.example.vishal.retrofitwithrealm.InterfaceData.InterfaceApi;
import com.example.vishal.retrofitwithrealm.R;
import com.example.vishal.retrofitwithrealm.ResponseData.RegData;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText fname, lname, email, password, phone;
    private Realm realm;
    private Button reg;
    private String sname, slname, semail, spassword, sphone;
    public static String URL_ROOT = "http://54.213.226.66/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fname = (EditText) findViewById(R.id.edt_fname);
        lname = (EditText) findViewById(R.id.edt_lname);
        email = (EditText) findViewById(R.id.edt_email);
        password = (EditText) findViewById(R.id.edt_password);
        phone = (EditText) findViewById(R.id.edt_phone);
        reg = (Button) findViewById(R.id.btn_reg);
        reg.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reg:

                getData();

                break;
        }

    }

    private void getData() {

        sname = fname.getText().toString();
        slname = lname.getText().toString();
        semail = email.getText().toString();
        spassword = password.getText().toString();
        sphone = phone.getText().toString();

        if (sname.isEmpty() && slname.isEmpty() && semail.isEmpty() && spassword.isEmpty() && sphone.isEmpty()) {

            Toast.makeText(MainActivity.this, "Please Filling Data", Toast.LENGTH_SHORT).show();


        } else {
            RegistrationData(sname, slname, semail, spassword, sphone);
        }
    }

    private void RegistrationData(String sname, String slname, String semail, String spassword, String sphone) {

//        Map<String,String> stringMap = new HashMap<>();
//        stringMap.put("firstName",sname);
//        stringMap.put("lastName",slname);
//        stringMap.put("email",semail);
//        stringMap.put("password",spassword);
//        stringMap.put("phone",sphone);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_ROOT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);

        Call<RegData> regDataCall = interfaceApi.reg_method_f(sname, slname, semail, spassword, sphone);

        regDataCall.enqueue(new Callback<RegData>() {
            @Override
            public void onResponse(Call<RegData> call, Response<RegData> response) {

                MyApplication.getInstance().showLog("Code", "" + response.code());

                if (response.isSuccessful()) {

                }if (response.code() == 200) {
                    MyApplication.getInstance().showLog("200", "" + response.code());
                    SetData(response);
                } else if (response.code() == 201) {
                    MyApplication.getInstance().showLog("201", "" + response.code());
                    SetData(response);
                } else {

                }
            }

            @Override
            public void onFailure(Call<RegData> call, Throwable t) {

                MyApplication.getInstance().showLog("error", t.getMessage());

            }
        });


    }

    private void SetData(Response<RegData> response) {

        realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        String regDatas = response.body().getMessage();
        boolean eoro = response.body().isError();

        regpojo user = realm.createObject(regpojo.class);
        user.setMsg(regDatas);
        user.setError(eoro);
        realm.commitTransaction();

        RealmResults<regpojo> results = realm.where(regpojo.class).findAll();

        MyApplication.getInstance().showLog("size",""+results.size());
        //  }


    }

    private void SaveIntoDatabase(Response<RegData> response) {




    }


}
