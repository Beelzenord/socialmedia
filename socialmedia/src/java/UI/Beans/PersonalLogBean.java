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
 * The PersonalLogBean is used to create new posts to a users log. The PersonalLogBean
 * is also used to represent the PersonalLog entity, much like a viewmodel.
 */
@ManagedBean
@SessionScoped
public class PersonalLogBean {
    private String text;
    private Date timePosted;
    private Long id;
    
    @ManagedProperty(value="#{usersBean}")
    private UsersBean userBean;
    
    private Long sendersID;
    
    
    Collection<PersonalLogBean> usersBeanCollection = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getSendersID() {
        return sendersID;
    }

    public void setSendersID(Long sendersID) {
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
