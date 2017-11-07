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
 */
public class UsersDB {
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
    public static Users loginUser(Users u){
         EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
         Query q = em.createNamedQuery("Users.findByName");
         q.setParameter("name", u.getUsername());
         Users user = (Users) q.getSingleResult();
         return user;
    }
    
    public static Collection<Users> getUsersById(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        Query q = em.createNamedQuery("Users.findById");
        q.setParameter("id", id);

        Collection<Users> tmp = q.getResultList();
        for (Users uw : tmp) {
            System.out.println("names: " + uw.getUsername());
        }
        return tmp;
    }
    
    public static Collection<Users> getAllUsers() {
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        Query q = em.createNamedQuery("Users.findAll");
        Collection<Users> tmp = q.getResultList();
        return tmp;
    }
    
    public static Collection<Users> getUsersByUsername(String name) {
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        Query q = em.createNamedQuery("Users.findByName");
        q.setParameter("name", name);

        Collection<Users> tmp = q.getResultList();
        for (Users uw : tmp) {
            System.out.println("names: " + uw.getUsername());
        }
        return tmp;
    }
}
