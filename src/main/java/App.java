import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.imageio.spi.ServiceRegistry;

public class App {

    public static void main(String [] args){
        Alien et = new Alien();
        et.setaID(101);
        et.setColor("Blue");
        et.setaName(new AlienName("ET","A.","Gill"));


//        et.setaID(104);
//        et.setaName("Uranus");
//        et.setColor("yellow");


        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

        //ServiceRegistry reg = new ServiceRegistryBuilder().applySettings().

        //SessionFactory is an interface
        SessionFactory sf = con.buildSessionFactory();

        //Session is interface
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // save data
        session.save(et);

        //fetch data
        //et = session.get(Alien.class,104);

        tx.commit();

        System.out.println(et);

    }
}
