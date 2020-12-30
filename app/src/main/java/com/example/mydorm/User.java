package com.example.mydorm;

import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class User {
    private String Name = "";
    private String Lastname ="";
    private String Faculty = "";
    private String Birthday = "";
    private String Gender = "";
    private String Email = "";
    private String IDNumber = "";
    private String Phonenumber = "";


    public User(String Name, String Lastname, String Gender, String Faculty, String Birthday, String Email, String IDNumber, String Phonenumber) {
        this.Name = Name;
        this.Lastname = Lastname;
        this.Faculty = Faculty;
        this.Birthday = Birthday;
        this.Email = Email;
        this.IDNumber = IDNumber;
        this.Phonenumber = Phonenumber;
        this.Gender = Gender;
    }


    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String Phonenumber) {
        this.Phonenumber = Phonenumber;
    }

    public boolean checkEmail(TextInputLayout regEmail){
        String email = regEmail.toString();

        if (email.contains("tau.edu.tr")==true){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean checkIDNumber(String e) {

        for (int i = 0; i < e.length(); i++) {
            if (e.charAt(0) != '0' && e.length() == 11) {
                return true;
            }
        }
        return false;
    }

}
