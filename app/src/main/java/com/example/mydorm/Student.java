package com.example.mydorm;

public class Student extends User {
    private String MatrNo, CourseofStudy, Semester;

    public Student(String name, String lastname, String faculty, String birthday, String gender, String email, String IDNumber, String phonenumber,String matrno, String cos, String semester) {
        super(name, lastname, faculty, birthday, gender, email, IDNumber, phonenumber);
        MatrNo = matrno;
        CourseofStudy = cos;
        Semester = semester;
    }

    public String getMatrNo() {
        return MatrNo;
    }

    public void setMatrNo(String matrNo) {
        MatrNo = matrNo;
    }

    public String getCourseofStudy() {
        return CourseofStudy;
    }

    public void setCourseofStudy(String courseofStudy) {
        CourseofStudy = courseofStudy;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }
    public static boolean checkMatrNo(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) != '0' && s.length() == 9) {
                return true;
            }
        }
        return false;
    }
}

