package com.example.ashirayyan.pulmonarycare.AccountAcivity;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashirayyan.pulmonarycare.Details;
import com.example.ashirayyan.pulmonarycare.R;

import java.util.List;

/**
 * Created by Ashir Ayyan on 4/10/2018.
 */

public class PatientList extends ArrayAdapter<Patient> {
    private Activity context;
    List<Patient> patientList;

    public PatientList(Activity context, List<Patient> patientList) {
        super(context, R.layout.list_layout, patientList);
        this.context = context;
        this.patientList = patientList;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGender = (TextView) listViewItem.findViewById(R.id.LblDisease);
        TextView textViewMIno = (TextView) listViewItem.findViewById(R.id.LblSymp);
        TextView textViewAge= (TextView) listViewItem.findViewById(R.id.textViewAge);

        Patient patient = patientList.get(position);
        textViewName.setText(patient.getname());
        textViewGender.setText(patient.getgender()+",");
        textViewMIno.setText(patient.getmiNo());
        textViewAge.setText(patient.getage());


        return listViewItem;

    }


    public Patient getItemAtPosition(int position) {

        Patient patient = patientList.get(position);

        return  patient;
    }
}
