package com.example.abhms.healthmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.btnNext).setOnClickListener(this::click);

    }

    private void click(View view) {

        JSONObject obj = new JSONObject();
        try {
            obj.put("userName", getUserName());
            obj.put("dob", getdob());
            //obj.put("gender",getgender());
            obj.put("address",getaddress());
            obj.put("bloodgroup",getblood());
            obj.put("mobileno",getmobile());
            obj.put("email",getemail());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Q.q(Register.this).add(new JsonObjectRequest("https://healthmanagement-b7215.firebaseio.com/login.json", obj, Register.this::success, Register.this::error));

    }


    private void error(VolleyError volleyError) {

    }

    private void success(JSONObject jsonObject) {

        Intent intent = new Intent(this, Register_emergency.class);
        startActivity(intent);
    }

    private String getUserName() {
        return ((EditText) findViewById(R.id.edtname)).getText().toString();
    }

    private String getdob() {
        return ((EditText) findViewById(R.id.edtdob)).getText().toString();
    }

    private String getaddress() {
        return ((EditText) findViewById(R.id.edtaddress)).getText().toString();
    }


    private String getblood() {
        return ((EditText) findViewById(R.id.edtbg)).getText().toString();
    }

    private String getmobile() {
        return ((EditText) findViewById(R.id.edtmobile)).getText().toString();
    }

    private String getemail() {
        return ((EditText) findViewById(R.id.edtemail)).getText().toString();
    }



}
