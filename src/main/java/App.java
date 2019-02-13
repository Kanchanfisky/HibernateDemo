import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String [] args){

//        Alien et = new Alien();
//        et.setaID(101);
//        et.setColor("Blue");
//        et.setaName(new AlienName("ET","A.","Gill"));


//        et.setaID(104);
//        et.setaName("Uranus");
//        et.setColor("yellow");


        Laptop laptop = new Laptop();
        laptop.setLaptopID(12);
        laptop.setLname("MacBook");

        Laptop laptop1 = new Laptop();
        laptop.setLaptopID(13);
        laptop.setLname("ASUS");


        Student student = new Student();
        student.setName("Nadim");
        student.setStudentID(23);
        student.setMarks(50);
        //student.setLaptop(laptop);
        student.getLaptops().add(laptop);
        student.getLaptops().add(laptop1);

       // Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);


        //ServiceRegistry reg = new ServiceRegistryBuilder().applySettings().

        //SessionFactory is an interface
        SessionFactory sf = con.buildSessionFactory();

        //Session is interface
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // save data
        //session.save(et);

        //fetch data
        //et = session.get(Alien.class,104);


        // For Student & Laptop Object

        //saving student and laptop objects to database
        session.save(laptop);
        session.save(student);





        tx.commit();

        //System.out.println(et);

    }
}
