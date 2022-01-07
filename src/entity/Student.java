package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
public class Student implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private String gender;
    private LocalDate date;
    private String contact;
    @OneToMany(mappedBy = "stuId")
    private List<ReserveDetails> details;

    public Student() {
    }

    public Student(String id, String name, String address, String gender, LocalDate date, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.date = date;
        this.contact = contact;
    }

    public Student(String id, String name, String address, String gender, LocalDate date, String contact, List<ReserveDetails> details) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.date = date;
        this.contact = contact;
        this.details = details;
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

    public List<ReserveDetails> getDetails() {
        return details;
    }

    public void setDetails(List<ReserveDetails> details) {
        this.details = details;
    }
}
