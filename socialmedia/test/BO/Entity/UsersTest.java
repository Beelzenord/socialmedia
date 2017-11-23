/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Entity;

import BO.Handlers.UsersHandler;
import UI.Beans.UsersBean;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Niklas
 * Testing Users entity users bean and UsersHandler.
 * See InitiateDB to set tables and tuples into a fresh database.
 */
public class UsersTest {
    public UsersTest() {
        
    }
    
    /**
     * Testing the creation of a user.
     */
    @Test
    public void TestCreateUser() {
        UsersBean usersBean = new UsersBean();
        usersBean.setUsername("testuser");
        usersBean.setPass("testpass");
        usersBean.setOccupation("testoccupation");
        UsersHandler.addUser(usersBean);
    }
    
    /**
     * Testing finding a user using their id.'
     * User 1 in the database should have username "u1", password "u1"
     * and occupation "u1 worker".
     */
    @Test
    public void TestFindUserWithId() {
        UsersBean b = new UsersBean();
        b.setId(new Long(1));
        Users u = UsersHandler.getUserById(b);
        assertEquals(new Long(1), u.getId());
        assertEquals("u1", u.getUsername());
        assertEquals("u1", u.getPass());
        assertEquals("u1 worker", u.getOccupation());
    }
    
    /**
     * Testing finding a user using their username.
     * User 2 in the database should have username "u2", password "u2"
     * and occupation "u2 worker".
     */
    @Test
    public void TestFindUserWithUsername() {
        UsersBean b = new UsersBean();
        b.setSearchForUser("u");
        Collection<UsersBean> u = UsersHandler.getUsersByContains(b);
        ArrayList<UsersBean> list = new ArrayList();
        for (UsersBean bs : u) {
            list.add(bs);
        }
        assertEquals(new Long(2), list.get(1).getId());
        assertEquals("u2", list.get(1).getUsername());
        assertEquals("u2 worker", list.get(1).getOccupation());
    }
    
    /**
     * Testing to log in a user.
     * User 1 in the database should have username "u1", password "u1"
     * and occupation "u1 worker".
     */
    @Test
    public void TestLogInUser() {
        UsersBean userBean = new UsersBean();
        userBean.setUsername("u1");
        userBean.setPass("u1");
        Users u = UsersHandler.loginUser(userBean);
        assertEquals(new Long(1), u.getId());
        assertEquals("u1", u.getUsername());
        assertEquals("u1", u.getPass());
        assertEquals("u1 worker", u.getOccupation());
    }
}
