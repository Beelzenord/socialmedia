/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Beans;

import java.util.Date;

/**
 *
 * @author Niklas
 */
public class LogBean {
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
    
    public static void addPost() {
        // call LogHandler
    }
}
