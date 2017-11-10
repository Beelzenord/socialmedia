/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Beans;

import BO.Handlers.PersonalLogHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import static org.slf4j.helpers.Util.report;

/**
 *
 * @author Niklas
 */
@ManagedBean
@SessionScoped
public class PersonalLogBean {
    private String text;
    private Date timePosted;
    private int id;
    
    @ManagedProperty(value="#{usersBean}")
    private UsersBean userBean;
    
    private int sendersID;
    
    
    Collection<PersonalLogBean> usersBeanCollection = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(Date timePosted) {
        this.timePosted = timePosted;
    }

    public int getSendersID() {
        return sendersID;
    }

    public void setSendersID(int sendersID) {
        this.sendersID = sendersID;
    }

    public Collection<PersonalLogBean> getUsersBean() {
        return usersBeanCollection;
    }

    public void setUsersBean(Collection<PersonalLogBean> usersBean) {
        this.usersBeanCollection = usersBean;
    
    }
    
    public void addPost() {
       PersonalLogHandler.addPostToLog(this);
    }
    
    public UsersBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UsersBean userBean) {
        this.userBean = userBean;
    }
             
}
