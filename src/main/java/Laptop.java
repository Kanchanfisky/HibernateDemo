import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {

    @Id
    private int laptopID;
    private String lname;


    //@ManyToOne
    @ManyToMany
    private List<Student> student = new ArrayList<Student>();


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

//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }


    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
