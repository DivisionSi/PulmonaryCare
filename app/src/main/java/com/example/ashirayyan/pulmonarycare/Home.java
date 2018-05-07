package com.example.ashirayyan.pulmonarycare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ashirayyan.pulmonarycare.AccountAcivity.LogInActivity;
import com.example.ashirayyan.pulmonarycare.AccountAcivity.Main2Activity;

public class Home extends AppCompatActivity {

    Button btnAddPatient,btnPatientList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnAddPatient = findViewById(R.id.btnAddPatient);
        btnPatientList = findViewById(R.id.btnPatientList);


        btnAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Main2Activity.class));
            }
        });

        btnPatientList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, PatientsList.class));

            }
        });
    }
}
