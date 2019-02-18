import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

//import javax.persistence.Query;

public class App {

    public static void main(String [] args){

//        Alien et = new Alien();
//        et.setaID(101);
//        et.setColor("Blue");
//        et.setaName(new AlienName("ET","A.","Gill"));


//        et.setaID(104);
//        et.setaName("Uranus");
//        et.setColor("yellow");

//
//        Laptop laptop = new Laptop();
//        laptop.setLaptopID(42);
//        laptop.setLname("Alienware");

//        Laptop laptop1 = new Laptop();
//        laptop.setLaptopID(90);
//        laptop.setLname("DELL");


//        Student student = new Student();
//        student.setName("Ram");
//        student.setStudentID(29);
//        student.setMarks(10);

//
//        Student student = new Student();
//        student.setName("Hari");
//        student.setStudentID(25);
//        student.setMarks(55);


        //student.setLaptop(laptop);


        // for many to many relationships , student has to add laptop and
        // laptop has to add student

//       student.getLaptops().add(laptop);
//       laptop.getStudent().add(student);



        //student.getLaptops().add(laptop1);







        // Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Book.class);


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

        //session.save(laptop);

        //session.save(laptop1);

        //session.save(student);

//        Random rand = new Random();
//
//        for(int i =1; i<=100; i++){
//            Book book = new Book();
//            book.setBookID(i);
//            book.setBookName("book" + i);
//            book.setBookWriter("writer"+i);
//            double randomValue = 10 + (500 - 10) * rand.nextDouble();
//            book.setPrice(randomValue);
//            session.save(book);
//        }



     System.out.println("--------------------------");

//     Query query1 = session.createQuery("from Book where price > 100.0");
//     List<Book> booksPriceLimit = ((org.hibernate.query.Query) query1).list();
//
//     for ( Book eachOne : booksPriceLimit){
//         System.out.println(eachOne);
//     }


        Query q = session.createQuery("select bookWriter, bookName, price from Book b where b.price < 20");
        List<Object[]> bookObjs = ( List<Object []>) q.list();

        for(Object[] bookObj : bookObjs){
            System.out.println(bookObj[0] + " : " + bookObj[1] + " : " + bookObj[2]);
        }


        System.out.println("------------------------------");

        // How to prevent against HQL injection attack
        // same way SQL prevents itself
        // By setting SQL parameters in query

        Query q2 = session.createQuery("select bookWriter, bookName, price from Book b where b.price < :price");
        q2.setParameter("price", 20);
        List<Object[]> bookObjsHQL = ( List<Object []>) q.list();

        for(Object[] bookObj : bookObjsHQL){
            System.out.println(bookObj[0] + " : " + bookObj[1] + " : " + bookObj[2]);
        }


        System.out.println("------------------------------");

        //update table using HQL

        String hqlUpdate = "UPDATE Book set price = :price "  +
                "WHERE bookID = :bookID";
        Query queryUpdate = session.createQuery(hqlUpdate);
        queryUpdate.setParameter("price", 16.927316117491069);
        queryUpdate.setParameter("bookID", 10);
        int resultUpdate = queryUpdate.executeUpdate();
        System.out.println("Rows affected: " + resultUpdate);


        System.out.println("------------------------------");


        // Delete
        String hqlDelete = "DELETE FROM Book WHERE bookID = :bookID";
        Query queryDel = session.createQuery(hqlDelete);
        queryDel.setParameter("bookID", 1);
        int resultDel = queryDel.executeUpdate();
        System.out.println("Rows affected: " + resultDel);


        System.out.println("------------------------------");


     // for unique result use queue.uniqueResult() which gives that particular object



        session.getTransaction().commit();
        //tx.commit();

        //System.out.println(et);

    }
}
