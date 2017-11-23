/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Handlers;

import DB.UsersDB;
import UI.Beans.UsersBean;
import BO.Entity.Users;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Niklas
 * The TUsersHandler is used as a transition between viewmodels and database entities.
 * There are methods to create new TUsers, finding users using their ID or searching
 * for the username. There is also functionality to logging in a user.
 */
public class UsersHandler {
    
    /**
     * Add a new User to the database. The UsersBean should contain 
     * the username, the password and the occupation of the new User. A new User entity
     * will be created using the information in the bean and will then be sent 
     * to UsersDB to be inserted into the database.
     * @param bean The UsersBean containing the information of the new Message.
     */
    public static void addUser(UsersBean userBean) {
        Users user = new Users();
        user.setUsername(userBean.getUsername());
        user.setPass(userBean.getPass());
        user.setOccupation(userBean.getOccupation());
        UsersDB.addNewUser(user);
    }
    
    /**
     * The method is used to log in a user. 
     * @param userBean The user to be authenticated.
     * @return A User that logged in successfully.
     */
    public static Users loginUser(UsersBean userBean){
        Users user = new Users();
        user.setUsername(userBean.getUsername());
        user.setPass(userBean.getPass());
        Users Real = UsersDB.loginUser(user);
        return Real;
    }
    
    /**
     * Finds a User searching for their ID.
     * @param b The user to be searched for.
     * @return A User that was found while searching for their ID. 
     */
    public static Users getUserById(UsersBean b) {
        return UsersDB.getUserById(b.getId());
    }
    
    /**
     * Finds all Users. 
     */
    public static void getAllUsers() {
        UsersDB.getAllUsers();
    }
    
    /**
     * Finds a User using their username.
     * @param b The user to be found.
     * @return A User that was found while searching for their username. 
     */
    public static Users getUserbyUsername(UsersBean b){
        Users tmp = new Users();
        tmp.setUsername(b.getUsername());
        tmp = UsersDB.loginUser(tmp);
        return tmp;
    }
    
    /**
     * Finds all users with the provided username.
     * @param b The bean which contains the username to be searched for.
     * @return A Collection of UsersBeans of all found users. 
     */
    public static Collection<UsersBean> getUsersByUsername(UsersBean b) {
        Collection<Users> users = UsersDB.getUsersByUsername(b.getSearchForUser());
        Collection<UsersBean> usersBean = new ArrayList();
        for (Users u : users) {
            UsersBean tmp = new UsersBean();
            tmp.setUsername(u.getUsername());
            tmp.setId(u.getId());
            tmp.setOccupation(u.getOccupation());
            usersBean.add(tmp);
        }
        return usersBean;
    }
    
    /**
     * Finds all users with a username that contains the searchString.
     * @param b The UsersBean the contains the string to be searched for.
     * @return A Collection of UsersBean of all found users. 
     */
    public static Collection<UsersBean> getUsersByContains(UsersBean b) {
        Collection<Users> users = UsersDB.getUsersByContains(b.getSearchForUser());
        return toUsersBean(users);
    }
    
    /**
     * Converts a Collection of Users to a Collection of UsersBean.
     * @param users The Collection of Users to be converted.
     * @return A Collection of UsersBean.
     */
    public static Collection<UsersBean> toUsersBean (Collection<Users> users) {
        Collection<UsersBean> usersBean = new ArrayList();
        for (Users u : users) {
            UsersBean tmp = new UsersBean();
            tmp.setUsername(u.getUsername());
            tmp.setId(u.getId());
            tmp.setOccupation(u.getOccupation());
            usersBean.add(tmp);
        }
        return usersBean;
    }
}
