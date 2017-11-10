
import BO.Entity.Messages;
import BO.Entity.PersonalLog;
import BO.Entity.Users;
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
        
        Messages m1 = new Messages(u1, u2, "to u2 from u1", false, false, new Date());
        Messages m2 = new Messages(u3, u2, "to u2 from u3", false, false, new Date());
        Messages m3 = new Messages(u3, u1, "to u1 from u3", false, false, new Date());
        Messages m4 = new Messages(u4, u1, "to u1 from u4", false, false, new Date());
        
        Set<Users> s = new HashSet<Users>();
        s.add(u1);
        Set<Users> s2 = new HashSet<Users>();
        s2.add(u2);
        u1.setUsersForUserId(s2);
        
        PersonalLog p1 = new PersonalLog("First log from u1", new Date(), u1);
        PersonalLog p2 = new PersonalLog("First log from u2", new Date(), u2);
        PersonalLog p3 = new PersonalLog("Second log from u2", new Date(), u2);
        PersonalLog p4 = new PersonalLog("First log from u3", new Date(), u3);
        
        
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
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        System.exit(0);
    }
}
