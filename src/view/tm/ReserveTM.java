package view.tm;

import entity.Program;
import entity.Student;

public class ReserveTM {
    private String studentId;
    private String proId;
    private String date;

    public ReserveTM() {
    }

    public ReserveTM(String studentId, String proId, String date) {
        this.studentId = studentId;
        this.proId = proId;
        this.date = date;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
