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
 */
public class PersonalLogHandler {
    public static void addPostToLog(PersonalLogBean bean) {
        PersonalLog pl = new PersonalLog();
        pl.setText(bean.getText());
        pl.setTimePosted(new Date());
        Users sender = UsersHandler.getUserbyUsername(bean.getUserBean());
        pl.setSender(sender);
        PersonalLogDB.addPostToLog(pl);
    }
    public static Collection<PersonalLog> getPostsFromOneUser(Long id){
        Collection<PersonalLog> tmp= PersonalLogDB.getPostsFromUser(id);
        return tmp;
    }
     public static Collection<PersonalLogBean> getPostsFromOneUser(String username){
        Collection<PersonalLog> tmp= PersonalLogDB.getPostsFromUser(username);
        return convertToPersonalLogBean(tmp);
    }
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
