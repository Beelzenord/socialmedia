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
 */
public class UsersHandler {
    public static void addUser(UsersBean userBean) {
        Users user = new Users();
        user.setUsername(userBean.getUsername());
        user.setPass(userBean.getPass());
        user.setOccupation(userBean.getOccupation());
        UsersDB.addNewUser(user);
    }
    public static Users loginUser(UsersBean userBean){
        Users user = new Users();
        user.setUsername(userBean.getUsername());
        user.setPass(userBean.getPass());
        Users Real = UsersDB.loginUser(user);
        return Real;

        
    }
    
    public static Users getUserById(UsersBean b) {
        return UsersDB.getUserById(b.getId());
    }
    
    public static void getUsersById(UsersBean b) {
      //  UsersDB.getUsersById(b.getId());
    }
    
    
    public static void getAllUsers() {
        UsersDB.getAllUsers();
    }
    public static Users getUserbyUsername(UsersBean b){
        Users tmp = new Users();
        tmp.setUsername(b.getUsername());
        tmp = UsersDB.loginUser(tmp);
        return tmp;
    }
    
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
    
    public static Collection<UsersBean> getUsersByContains(UsersBean b) {
        Collection<Users> users = UsersDB.getUsersByContains(b.getSearchForUser());
        return toUsersBean(users);
    }
    
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
