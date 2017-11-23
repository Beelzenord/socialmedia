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
 * MessagesDB is used to access the database for the Messages entity.
 */
public class MessagesDB {
    /**
     * Adds a new Message to the database.
     * @param m The Message to be added to the database.
     */
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
    
    /**
     * Sets the IsRead attribute of a Message to true.
     * @param id The ID of the Message.
     */
    public static void setMessageToIsRead(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Messages m = em.find(Messages.class, id);
            m.setIsRead(true);
            em.merge(m);
            em.getTransaction().commit();
        } finally {
            if (em != null)
                em.close();
        }
    }
    
    /**
     * Finds a Message by search for the ID.
     * @param id The ID of the Message to be searched for.
     * @return The Message that was found.
     */
    public static Messages getMessageWithId(Long id) {
        EntityManager em = getEntityManager();
        Messages tmp = null;
        try {
            tmp = em.find(Messages.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return tmp;
    }
    
    /**
     * Finds all Messages directed at a receiver.
     * @param receiver_id The ID of the receiver.
     * @return A Collection of Messages found. 
     */
    public static Collection<Messages> getMessagesFromAll(Long receiver_id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Messages.findFromAll");
            q.setParameter("Receiver_id", receiver_id);
            Collection<Messages> tmp = q.getResultList();
            return tmp;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    /**
     * Finds all Message directed at a single user from a single user. 
     * @param receiver_id The ID of the receiver.
     * @param sender_id The ID of the sender.
     * @return A Collection of all Messages Found.
     */
    public static Collection<Messages> getMessagesFromOneSender(Long receiver_id, Long sender_id) {
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        try {
            Query q = em.createNamedQuery("Messages.findFromOneSender");
            q.setParameter("Receiver_id", receiver_id);
            q.setParameter("Sender_id", sender_id);
            Collection<Messages> tmp = q.getResultList();
            return tmp;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     * The EntityManager needed to access the database.
     * @return The EntityManager needed to access the database.
     */
    private static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("FacePU").createEntityManager();
    }
}
