import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {

    @Id
    private int laptopID;
    private String lname;


    public int getLaptopID() {
        return laptopID;
    }

    public void setLaptopID(int laptopID) {
        this.laptopID = laptopID;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
