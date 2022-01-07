package entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class Program implements SuperEntity{
    @Id
    private  String  id;
    private String program;
    private String duration;
    private double fee;
    @OneToMany(mappedBy = "proID",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReserveDetails> reserveDetails;

    public void addProgram(ReserveDetails details) {
        reserveDetails.add(details);
        details.setProID(this);
    }

    public void removeProgram(ReserveDetails details) {
        reserveDetails.remove(details);
        details.setProID(null);
    }

    public Program() {
    }

    public Program(String id, String program, String duration, double fee) {
        this.id = id;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
    }

    public Program(String id, String program, String duration, double fee, List<ReserveDetails> reserveDetails) {
        this.id = id;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
        this.reserveDetails = reserveDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<ReserveDetails> getReserveDetails() {
        return reserveDetails;
    }

    public void setReserveDetails(List<ReserveDetails> reserveDetails) {
        this.reserveDetails = reserveDetails;
    }
}
