
import BO.Entity.Messages;
import BO.Entity.PersonalLog;
import BO.Entity.Users;
import BO.Handlers.PersonalLogHandler;
import BO.Handlers.UsersHandler;
import DB.PersonalLogDB;
import UI.Beans.MessageBean;
import UI.Beans.PersonalLogBean;
import UI.Beans.UsersBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Niklas
 */
public class InitiateDB {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FacePU");
        EntityManager em = emf.createEntityManager();
        
        Users u1 = new Users("u1", "u1", "u1 worker");
        Users u2 = new Users("u2", "u2", "u2 worker");
        Users u3 = new Users("u3", "u3", "u3 worker");
        Users u4 = new Users("u4", "u4", "u4 worker");
        
        Messages m1 = new Messages(u1, u2, "to u2 from u1", false, false);
        Messages m2 = new Messages(u3, u2, "to u2 from u3", false, false);
        Messages m3 = new Messages(u3, u1, "to u1 from u3", false, false);
        Messages m4 = new Messages(u4, u1, "to u1 from u4", false, false);
        
        Set<Users> s = new HashSet<Users>();
        s.add(u1);
        Set<Users> s2 = new HashSet<Users>();
        s2.add(u2);
        u1.setUsersForUserId(s2);
        //u2.setUsersForUserId(s);
        
        PersonalLog pl = new PersonalLog();
        pl.setText("this is log text");
        pl.setTimePosted(new Date());
        pl.setSender(u1);
        
        
        
      //  pl.setTimePosted(date);
        
        try {
            em.getTransaction().begin();
            em.persist(u1);
            em.persist(u2);
            em.persist(u3);
            em.persist(u4);
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);
            em.persist(m4);
            em.persist(pl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        System.exit(0);
    }
}
