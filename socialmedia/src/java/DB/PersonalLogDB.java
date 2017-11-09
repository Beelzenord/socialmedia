/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import BO.Entity.Messages;
import BO.Entity.PersonalLog;
import BO.Entity.Users;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Niklas
 */
public class PersonalLogDB {
        public static void addPostToLog(PersonalLog pl){
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(pl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
      }
        public static Collection<PersonalLog> getPostsFromUser(int id){
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        Query q = em.createNamedQuery("PersonalLog.findFromOneSender");
        q.setParameter("Sender_id", id);
        Collection<PersonalLog> tmp = q.getResultList();
        em.close();
        return tmp;
        }
}
