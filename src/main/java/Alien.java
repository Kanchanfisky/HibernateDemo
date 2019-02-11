import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name = "tblAlien")
public class Alien { // POJO

    @Id
   private int aID;

    // @Transient // data will not be stored in table
   private AlienName aName;

   @Column(name="alienColor")
   private String color;


    public int aID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AlienName getaName() {
        return aName;
    }

    public void setaName(AlienName aName) {
        this.aName = aName;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aID=" + aID +
                ", aName='" + aName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
