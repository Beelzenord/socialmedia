/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import BO.Entity.PersonalLog;
import BO.Entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
}
