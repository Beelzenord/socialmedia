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
        UsersDB.addNewUser(user);
    }
}
