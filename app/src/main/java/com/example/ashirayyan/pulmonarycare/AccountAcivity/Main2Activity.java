package com.example.ashirayyan.pulmonarycare.AccountAcivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ashirayyan.pulmonarycare.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    //view objects
    EditText editTextName;
    EditText editTextMIno;
    EditText editTextAge;
    EditText editTextGender;
    Button buttonAddpatient;
    //our database reference object
    DatabaseReference databasePatient;
    ListView listViewPatients;
    List <Patient> patientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        databasePatient=FirebaseDatabase.getInstance().getReference("Patients");
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextMIno = (EditText) findViewById(R.id.editTextMIno);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextGender = (EditText) findViewById(R.id.editTextGender);
        buttonAddpatient = (Button) findViewById(R.id.buttonAddpatient);




        buttonAddpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPatient();

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void addPatient() {
        //getting the values to save
        
        String name = editTextName.getText().toString().trim();
        String mino = editTextMIno.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        String gender = editTextGender.getText().toString().trim();
        if (!TextUtils.isEmpty(name)) {
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databasePatient.push().getKey();

            //creating an Artist Object
            Patient patient = new Patient(id, name,age,mino,gender);
            databasePatient.child(id).setValue(patient);
            //displaying a success toast
            Toast.makeText(this, "Patient added", Toast.LENGTH_LONG).show();
        }
        else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }

}

