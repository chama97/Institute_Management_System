package entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReserveDetailPK implements Serializable {
    private String sId;
    private String pId;

    public ReserveDetailPK() {
    }

    public ReserveDetailPK(String sId, String pId) {
        this.sId = sId;
        this.pId = pId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
