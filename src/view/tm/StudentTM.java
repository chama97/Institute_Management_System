package view.tm;

import java.time.LocalDate;
import java.util.Date;

public class StudentTM {
    private String id;
    private String name;
    private String address;
    private String gender;
    private LocalDate date;
    private String contact;

    public StudentTM() {
    }

    public StudentTM(String id, String name, String address, String gender, LocalDate date, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.date = date;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
