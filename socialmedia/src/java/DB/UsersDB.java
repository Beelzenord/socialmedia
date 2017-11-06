/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import BO.Entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author fauzianordlund
 */
public class UsersDB {
    
    public UsersDB() {
    }
    public static void addNewUser(Users u){
        EntityManager em = Persistence.createEntityManagerFactory("FacePU").createEntityManager();
        try {
            //em = getEntityManager();
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
