package com.example.ashirayyan.pulmonarycare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Details extends AppCompatActivity {

    DatabaseReference databasePatient;
    Integer label;
    TextView symptom,disease;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        symptom = findViewById(R.id.txtSymptom);
        disease = findViewById(R.id.txtDiseases);
        Intent i=getIntent();
        Bundle b =i.getExtras();

        String passedMiNo= b.getString("miNo");

        databasePatient= FirebaseDatabase.getInstance().getReference("result");

        databasePatient.orderByChild("miNo").equalTo(passedMiNo).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                label = Integer.parseInt(dataSnapshot.child("field1").getValue().toString());
                setSymptom(label);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void setSymptom(Integer label) {

        if(label==0)
        {
            symptom.setText("Wheeze");
            disease.setText("Asthama, Alzheimers");

        }
        else if(label==1)
        {
            symptom.setText("Crackles");
            disease.setText("Cancer, Typhoid, Maleria");

        }

        // Rest of the labels will be hard-coded here

    }
}
