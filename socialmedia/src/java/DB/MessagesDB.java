/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import BO.Entity.Messages;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Niklas
 */
public class MessagesDB {
    public static void addNewUser(Messages m){
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static Collection<Messages> getMessagesFromUser(String sender) {
        /*Query q = em.createQuery("select * from T_Messages where sender in (:namesList)"); 
        q.setParameter("namesList", names); 
        List students = q.list()*/
        return null;
    }
}
