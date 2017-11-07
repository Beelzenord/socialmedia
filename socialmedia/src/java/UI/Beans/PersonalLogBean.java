/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Beans;

import BO.Handlers.PersonalLogHandler;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Niklas
 */
@ManagedBean
@SessionScoped
public class PersonalLogBean {
    private String text;
    private Date timePosted;

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
    
    public void addPost() {
        PersonalLogHandler.addPostToLog(this);
    }
}
