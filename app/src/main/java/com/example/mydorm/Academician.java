package com.example.mydorm;

public class Academician extends User {
    private String SubjectArea, PersonnelNumber;


    public Academician(String name, String lastname, String gender, String faculty, String birthday, String email, String IDNumber, String phonenumber, String sarea, String personnelno) {
        super(name, lastname, gender, faculty, birthday, email, IDNumber, phonenumber);
        SubjectArea = sarea;
        PersonnelNumber = personnelno;
    }

    public String getSubjectArea() {
        return SubjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        SubjectArea = subjectArea;
    }

    public String getPersonnelNumber() {
        return PersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        PersonnelNumber = personnelNumber;
    }
    public static boolean checkPersonnelNo(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) != '0' && s.length() == 9) {
                return true;
            }
        }
        return false;
    }
}
