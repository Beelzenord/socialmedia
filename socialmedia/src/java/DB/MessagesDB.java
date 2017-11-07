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
import javax.persistence.Query;

/**
 *
 * @author Niklas
 */
public class MessagesDB {
    public static void addNewMessage(Messages m){
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
    
    public static Collection<Messages> getMessagesFromAll(int receiver_id) {
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        Query q = em.createNamedQuery("Messages.findFromAll");
        q.setParameter("Receiver_id", receiver_id);
        Collection<Messages> tmp = q.getResultList();
        em.close();
        return tmp;
    }
    
    public static Collection<Messages> getMessagesFromOneSender(int receiver_id, int sender_id) {
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        Query q = em.createNamedQuery("Messages.findFromOneSender");
        q.setParameter("Receiver_id", receiver_id);
        q.setParameter("Sender_id", sender_id);
        Collection<Messages> tmp = q.getResultList();
        em.close();
        return tmp;
    }
}
