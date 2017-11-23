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
 * PersonalLogDB is used to access the database for the PersonalLog entity.
 */
public class PersonalLogDB {
    /**
     * Adds a new PersonalLog to the database.
     * @param pl The PersonalLog to be added to the database.
     */
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
    
    /**
     * Finds all posts made by a single user.
     * @param id The ID of the user who made the posts.
     * @return A Collection of PersonalLog of all posts found.
     */
    public static Collection<PersonalLog> getPostsFromUser(Long id){
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        try {
            Query q = em.createNamedQuery("PersonalLog.findFromOneSender");
            q.setParameter("Sender_id", id);
            Collection<PersonalLog> tmp = q.getResultList();
            return tmp;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
        
    /**
     * Finds all posts made by a single user.
     * @param username The username of the user who made the posts.
     * @return A Collection of PersonalLog of all posts found.
     */
    public static Collection<PersonalLog> getPostsFromUser(String username){
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        try {
            Query q = em.createNamedQuery("PersonalLog.findFromOneSenderName");
            q.setParameter("Sender_Name", username);
            Collection<PersonalLog> tmp = q.getResultList();
            return tmp;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
