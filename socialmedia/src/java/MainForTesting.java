
import BO.Entity.Messages;
import BO.Entity.Users;
import UI.Beans.MessageBean;
import UI.Beans.UsersBean;
import java.util.Collection;
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
public class MainForTesting {
    public static void main(String[] args) {
         /*      EntityManagerFactory emf = Persistence.createEntityManagerFactory("FacePU");
        EntityManager em = emf.createEntityManager();
        Messages m = new Messages();
        m.setMessageText("testtext");
        Users u = new Users();
        Users u2 = new Users();
        u2.setUsername("u1");
        u2.setPass("u2");
        u.setUsername("u1");
        u.setPass("asd2");
        m.setSender(u);
        m.setReceiver(u2);
        u.getMessages().add(m);
        Set<Users> s = new HashSet<Users>();
        s.add(u);
        Set<Users> s2 = new HashSet<Users>();
        s2.add(u2);
        u.setUsersForUserId(s2);
        //u2.setUsersForUserId(s);
        System.out.println("print \n" + u.getMessages().toString());
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.persist(u2);
            em.persist(m);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        System.out.println("dones");
        */
        UsersBean b = new UsersBean();
        b.setUsername("u1");
        b.getUsersByUsername();
        
        System.out.println("lulul");
        Collection<UsersBean> t = b.getOtherUsers();
        for (UsersBean a : t) {
            System.out.println("test: " + a.getUsername());
        }
        
        System.out.println("again");
        
        MessageBean mb = new MessageBean();
        mb.getMessagesFromAll(2);
        Collection<MessageBean> test = mb.getMessages();
        for (MessageBean q : test) {
            System.out.println("messages: " + q.getMessageText());
        }
        mb.setMessageText("newtest1");
        UsersBean re = new UsersBean();
        re.setId(2);
        UsersBean se = new UsersBean();
        se.setId(1);
        mb.setReceiver(re);
        mb.setSender(se);
        mb.addNewMessage();
        
        mb.getMessagesFromAll(2);
        test = mb.getMessages();
        for (MessageBean q : test) {
            System.out.println("messages: " + q.getMessageText());
        }
        */
        System.exit(0);
    }
}
