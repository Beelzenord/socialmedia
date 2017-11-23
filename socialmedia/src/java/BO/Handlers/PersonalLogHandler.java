/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Handlers;

import BO.Entity.PersonalLog;
import BO.Entity.Users;
import DB.PersonalLogDB;
import UI.Beans.PersonalLogBean;
import UI.Beans.UsersBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Niklas
 * The PersonalLogHandler is used as a transition between viewmodels and database entities.
 * There are methods to create new Posts, finding logs from specific users. 
 */
public class PersonalLogHandler {
    
    /**
     * Add a new Post to the database. The PersonalLogBean should contain 
     * the ID of the user, and a body text. A new PersonalLog entity
     * will be created using the information in the bean and will then be sent 
     * to PersonalLogDB to be inserted into the database.
     * @param bean The PersonalLogBean containing the information of the new PersonalLog.
     */
    public static void addPostToLog(PersonalLogBean bean) {
        PersonalLog pl = new PersonalLog();
        pl.setText(bean.getText());
        pl.setTimePosted(new Date());
        Users sender = UsersHandler.getUserbyUsername(bean.getUserBean());
        pl.setSender(sender);
        PersonalLogDB.addPostToLog(pl);
    }
    
    /**
     * Find Posts from a specific user using their ID.
     * @param id The ID of the user who wrote the log.
     * @return A Collection of PersonalLog.
     */
    public static Collection<PersonalLog> getPostsFromOneUser(Long id){
        Collection<PersonalLog> tmp= PersonalLogDB.getPostsFromUser(id);
        return tmp;
    }
    
    /**
     * Find Posts from a specific user using their ID.
     * @param username The username of the user who wrote the log.
     * @return A Collection of PersonalLogBean.
     */
     public static Collection<PersonalLogBean> getPostsFromOneUser(String username){
        Collection<PersonalLog> tmp= PersonalLogDB.getPostsFromUser(username);
        return convertToPersonalLogBean(tmp);
    }
     
     /**
      * Converts a Collection of PersonalLog to a Collection of PersonalLogBean.
      * @param personalLogs The Collection of PersonalLog to be converted.
      * @return The Collection of PersonalLogBean.
      */
    private static Collection<PersonalLogBean> convertToPersonalLogBean(Collection<PersonalLog> personalLogs) {
        Collection<PersonalLogBean> logBeans = new ArrayList();
        for (PersonalLog l : personalLogs) {
            PersonalLogBean tmp = new PersonalLogBean();
            tmp.setText(l.getText());
            tmp.setTimePosted(l.getTimePosted());
            logBeans.add(tmp);
        }
        return logBeans;
    }
}
