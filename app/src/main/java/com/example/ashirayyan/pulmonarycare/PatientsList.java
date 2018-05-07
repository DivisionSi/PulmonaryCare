package com.example.ashirayyan.pulmonarycare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ashirayyan.pulmonarycare.AccountAcivity.Patient;
import com.example.ashirayyan.pulmonarycare.AccountAcivity.PatientList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PatientsList extends AppCompatActivity {

    ListView listViewPatients;
    List<Patient> patientList;
    DatabaseReference databasePatient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_list);

        databasePatient= FirebaseDatabase.getInstance().getReference("Patients");
        listViewPatients = (ListView) findViewById(R.id.lv_Patients);
        patientList=new ArrayList<>();

        patientList.clear();
        final PatientList adapter=new PatientList(PatientsList.this,patientList);
        listViewPatients.setAdapter(adapter);

        listViewPatients.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Patient p = adapter.getItemAtPosition(position);
                Intent intent= new Intent(PatientsList.this, Details.class);
                Bundle b = new Bundle();
                b.putString("miNo",p.getmiNo());
                intent.putExtras(b);
                startActivity(intent);
                //Toast.makeText(getBaseContext(),p.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

        databasePatient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot patientSnapshot:dataSnapshot.getChildren() ){
                    Patient patient =patientSnapshot.getValue(Patient.class);

                    patientList.add(patient);
                    Log.e("Patients", patient.getname());
                adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
