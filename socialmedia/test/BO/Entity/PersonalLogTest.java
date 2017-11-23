/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Entity;

import BO.Handlers.PersonalLogHandler;
import UI.Beans.PersonalLogBean;
import UI.Beans.UsersBean;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Niklas
 * Testing the PersonalLogEntity personal log bean and PersonalLogHandler.
 * See InitiateDB to set tables and tuples into a fresh database.
 */
public class PersonalLogTest {
    public PersonalLogTest() {
        
    }
    
    /**
     * Testing the creation of new PersonalLogs.
     */
    @Test
    public void TestCreatePersonalLog() {
        PersonalLogBean b = new PersonalLogBean();
        b.setText("testpost");
        UsersBean u = new UsersBean();
        u.setId(new Long(1));
        u.setUsername("u1");
        b.setUserBean(u);
        PersonalLogHandler.addPostToLog(b);
    }
    
    /**
     * Testing getting logs from a user using their id.
     * The first post should be from user 1 and the body text should be
     * "First log from u1".
     */
    @Test
    public void TestGetPostsFromOneUserId() {
        Collection<PersonalLog> b = PersonalLogHandler.getPostsFromOneUser(new Long(1));
        ArrayList<PersonalLog> list = new ArrayList();
        for (PersonalLog bs : b) {
            list.add(bs);
        }
        assertEquals("First log from u1", list.get(0).getText());
        assertEquals(new Long(1), list.get(0).getId());
    }
    
    /**
     * Testing finding post from one user using their username.
     * The second post should be by user 2 and the body text should be
     * "First log from u2".
     */
    @Test
    public void TestGetPostsFromOneUserName() {
        Collection<PersonalLogBean> b = PersonalLogHandler.getPostsFromOneUser("u2");
        ArrayList<PersonalLogBean> list = new ArrayList();
        for (PersonalLogBean bs : b) {
            list.add(bs);
        }
        assertEquals("First log from u2", list.get(0).getText());
    }
}
