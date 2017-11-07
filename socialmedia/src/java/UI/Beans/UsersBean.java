/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Beans;

import BO.Handlers.UsersHandler;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fauzianordlund
 */
@ManagedBean
@SessionScoped
public class UsersBean {
    private int id;
    private String username;
    private String pass;
    private String occupation;
    private Collection<MessageBean> messages;
    private Collection<UsersBean> otherUsers;
    
    /**
     * Creates a new instance of UserBean
     */
    public UsersBean() {
    }

    public Collection<MessageBean> getMessages() {
        return messages;
    }

    public void setMessages(Collection<MessageBean> messages) {
        this.messages = messages;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Collection<UsersBean> getOtherUsers() {
        return otherUsers;
    }

    public void setOtherUsers(Collection<UsersBean> otherUsers) {
        this.otherUsers = otherUsers;
    }
    
    public void addUser(){
        UsersHandler.addUser(this);
    }
    public String logUser(){
       return UsersHandler.loginUser(this);
    }
    
    public void getUsersById() {
        UsersHandler.getUsersById(this);
    }
    
    public void getAllUsers() {
        UsersHandler.getAllUsers();
    }
    
    public void getUsersByUsername() {
        otherUsers = UsersHandler.getUsersByUsername(this);
    }
    
    public void getMessagesFromUser() {
        //MessagesHandler.getMessagesFromUser()
    }
}
