/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import BO.Entity.Users;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author fauzianordlund
 * UsersDB is used to access the database for the Users entity.
 */
public class UsersDB {
    /**
     * Adds a new User to the database.
     * @param u The User to be added to the database.
     */
    public static void addNewUser(Users u){
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     * This method is used to logging in a User. 
     * @param u The user to be logged in.
     * @return The User who logged in.
     */
    public static Users loginUser(Users u){
         EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        try {
            Query q = em.createNamedQuery("Users.findByName");
            q.setParameter("name", u.getUsername());
            Users user = (Users) q.getSingleResult();
            return user;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     * Finds a User using their ID.
     * @param id The ID of the user to be found.
     * @return The user found by searching for their ID.
     */
    public static Users getUserById(Long id) {
        EntityManager em = getEntityManager();
        Users tmp = null;
        try {
            tmp = em.find(Users.class, id);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return tmp;
    }
    
    /**
     * Finds all users in the database.
     * @return A Collection of all users found in the database.
     */
    public static Collection<Users> getAllUsers() {
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        try {
            Query q = em.createNamedQuery("Users.findAll");
            Collection<Users> tmp = q.getResultList();
            return tmp;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    } 
    
    /**
     * Finds all users by searching for their username.
     * @param name The username to search for.
     * @return A Collection of Users found.
     */
    public static Collection<Users> getUsersByUsername(String name) {
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        try {
            Query q = em.createNamedQuery("Users.findByName");
            q.setParameter("name", name);
            Collection<Users> tmp = q.getResultList();
            return tmp;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     * Finds all Users with a username containing the searchString.
     * @param searchString The searchString to search for.
     * @return A Collection of all Users found.
     */
    public static Collection<Users> getUsersByContains(String searchString) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Users.findByContains");
            q.setParameter("searchString", "%" + searchString + "%");
            Collection<Users> tmp = q.getResultList();
            return tmp;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    private static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("FacePU").createEntityManager();
    }
}
