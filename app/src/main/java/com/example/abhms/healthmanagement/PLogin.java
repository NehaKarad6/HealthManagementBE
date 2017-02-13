package com.example.abhms.healthmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

//import android.text.TextUtils;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;

public class PLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plogin);

        findViewById(R.id.btnPatientLogin1).setOnClickListener(PLogin.this::login);
    }

    private void login(View view) {

        JSONObject obj = new JSONObject();
        try {
            obj.put("userName", getUserID());
            obj.put("password", getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Q.q(PLogin.this).add(new JsonObjectRequest("https://healthmanagement-b7215.firebaseio.com/login.json", obj, PLogin.this::success, PLogin.this::error));
    }

    private void error(VolleyError volleyError) {
        //findViewById(R.id.progressBar).setVisibility(View.GONE);
        //findViewById(R.id.btnRegister).setEnabled(true);
    }

    private void success(JSONObject jsonObject) {

        Intent intent = new Intent(this, Patient_dash.class);
        startActivity(intent);
    }

    private String getUserID() {
        return ((EditText) findViewById(R.id.PatientID)).getText().toString();
    }

    private String getPassword() {
        return ((EditText) findViewById(R.id.PatientPassword)).getText().toString();

    }
}
