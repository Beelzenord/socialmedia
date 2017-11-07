/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Handlers;

import BO.Entity.PersonalLog;
import DB.PersonalLogDB;
import UI.Beans.PersonalLogBean;

/**
 *
 * @author Niklas
 */
public class PersonalLogHandler {
    public static void addPostToLog(PersonalLogBean bean) {
        PersonalLog pl = new PersonalLog();
        pl.setText(bean.getText());
        pl.setTimePosted(bean.getTimePosted());
        PersonalLogDB.addPostToLog(pl);
    }
}
