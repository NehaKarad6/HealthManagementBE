package com.example.abhms.healthmanagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PInsurance extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private String cname;
    private String pno;
    private String name;
    private String plan;
    private String coverage;
    private String cov_end;
    private String cov_start;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinsurance);
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
}
