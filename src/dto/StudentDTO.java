package dto;

import java.time.LocalDate;
import java.util.Date;

public class StudentDTO {
    private String id;
    private String name;
    private String address;
    private String gender;
    private LocalDate date;
    private String contact;

    public StudentDTO() {
    }

    public StudentDTO(String id, String name, String address, String gender, LocalDate date, String contact) {
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", date=" + date +
                ", contact='" + contact + '\'' +
                '}';
    }
}
