package com.example.ashirayyan.pulmonarycare.AccountAcivity;

/**
 * Created by Saad on 06/05/2018.
 */

public class Patient {
    private String id;
    private String name;
    private String age;
    private String miNo;
    private String gender;

    public Patient(){}

    public Patient(String Id, String Name, String Age, String MiNo, String Gender) {
        this.id = Id;
        this.name = Name;
        this.age = Age;
        this.miNo = MiNo;
        this.gender = Gender;


    }

    public String getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String getage() {
        return age;
    }

    public String getmiNo() {
        return miNo;
    }

    public String getgender() {
        return gender;
    }
}
