package com.example.abhms.healthmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private String mobile;
    private String address;
    private String dob;
    private String weight;
    private String bg;
    private String emerg_contact;
    private String relation;
    private String emerg_mob;
    private String name;
    private String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bundle bundle = getIntent().getExtras();
         name = bundle.getString("name");
        email = bundle.getString("email");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        findViewById(R.id.btnSubmit).setOnClickListener(this::click);

    }

    private void click(View view) {

        mobile=((EditText) findViewById(R.id.edtMobileNumber)).getText().toString();
        address=((EditText) findViewById(R.id.EdtAddress)).getText().toString();
        dob=((EditText) findViewById(R.id.EdtDOB)).getText().toString();
        weight=((EditText) findViewById(R.id.EdtWeight)).getText().toString();
        bg=((EditText) findViewById(R.id.EdtBloodGroup)).getText().toString();
        emerg_contact=((EditText) findViewById(R.id.EdtEmergencyContact)).getText().toString();
        relation=((EditText) findViewById(R.id.EdtRelation)).getText().toString();
        emerg_mob=((EditText) findViewById(R.id.EdtEmgMob)).getText().toString();


      Patient p=new Patient(name,email,mobile,address,dob,weight,bg,emerg_contact,relation,emerg_mob);

        mDatabase.child("patients").child(mobile).setValue(p);
        Intent intent = new Intent(this, Patient_dash.class);

        startActivity(intent);
    }





}
