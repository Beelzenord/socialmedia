/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Handlers;

import DB.UsersDB;
import UI.Beans.UsersBean;
import BO.Entity.Users;

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
    public static String loginUser(UsersBean userBean){
        Users user = new Users();
        user.setUsername(userBean.getUsername());
        user.setPass(userBean.getPass());
        Users Real = UsersDB.loginUser(user);
        
        if(Real!=null){
            return "index";
        }
        else{
            return "failure";
        }
        
    }
    
    public static void getUsersById(UsersBean b) {
        UsersDB.getUsersById(b.getId());
    }
    
    public static void getAllUsers() {
        UsersDB.getAllUsers();
    }
    
    public static void getUsersByUsername(UsersBean b) {
        UsersDB.getUsersByUsername(b.getUsername());
    }
}
