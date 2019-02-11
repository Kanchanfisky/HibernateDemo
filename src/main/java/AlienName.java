import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class AlienName {

    private String fname;
    private String mname;
    private String lname;


    public AlienName(String fname, String mname, String lname) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;

    }

    public AlienName() {
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }


    public String getFname() {
        return fname;
    }


    @Override
    public String toString() {
        return "AlienName{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", mname='" + mname + '\'' +
                '}';
    }


}
