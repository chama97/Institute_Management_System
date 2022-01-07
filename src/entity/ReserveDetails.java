package entity;

import javax.persistence.*;

@Entity
public class ReserveDetails implements SuperEntity{
    @EmbeddedId
    private ReserveDetailPK reserveDetailPK;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", insertable = false, updatable = false)
    private Student stuId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", insertable = false, updatable = false)
    private Program proID;
    private String date;


    public ReserveDetails() {
    }

    public ReserveDetails(String stuId, String proID, String date) {
        this.reserveDetailPK = new ReserveDetailPK(stuId, proID);
        this.date = date;
    }

    public ReserveDetails(Student stuId, Program proID, String date) {
        this.stuId = stuId;
        this.proID = proID;
        this.reserveDetailPK=new ReserveDetailPK(stuId.getId(), proID.getId());
        this.date = date;
    }

    public ReserveDetails(ReserveDetailPK reserveDetailPK, Student stuId, Program proID, String date) {
        this.reserveDetailPK = reserveDetailPK;
        this.stuId = stuId;
        this.proID = proID;
        this.date = date;
    }

    public ReserveDetailPK getReserveDetailPK() {
        return reserveDetailPK;
    }

    public void setReserveDetailPK(ReserveDetailPK reserveDetailPK) {
        this.reserveDetailPK = reserveDetailPK;
    }

    public Student getStuId() {
        return stuId;
    }

    public void setStuId(Student stuId) {
        this.stuId = stuId;
    }

    public Program getProID() {
        return proID;
    }

    public void setProID(Program proID) {
        this.proID = proID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
