/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Beans;

import BO.Entity.Users;
import BO.Handlers.UsersHandler;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author fauzianordlund
 */
@ManagedBean
@SessionScoped
public class UsersBean {
    private Long id;
    private String username;
    private String pass;
    private String occupation;
    private String searchForUser;
    private Collection<MessageBean> messages;
    private Collection<UsersBean> otherUsers;
    private DataModel presentedUsers;
    
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSearchForUser() {
        return searchForUser;
    }

    public void setSearchForUser(String searchForUser) {
        this.searchForUser = searchForUser;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public DataModel getPresentedUsers() {
        return presentedUsers;
    }

    public void setPresentedUsers(DataModel presentedUsers) {
        this.presentedUsers = presentedUsers;
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
    public String logUser() {

        //return UsersHandler.loginUser(this);
        Users Real = UsersHandler.loginUser(this);

        if (Real != null) {
            this.id = Real.getId();
            this.occupation = Real.getOccupation();
            this.username = Real.getUsername();
            resetInfo();
            return "main";
        } else {
            return "failure";
        }
    }
    
    public void resetInfo() {
        searchForUser = "";
    }
    
    public void sendMessageToSelectedUser() {
        UsersBean b = (UsersBean)presentedUsers.getRowData();
        username = b.getUsername();
    }
    
    public void getAllUsers() {
        UsersHandler.getAllUsers();
    }
    
    public void getUsersByUsername() {
        otherUsers = UsersHandler.getUsersByUsername(this);
    }
    
    public void getUsersByContains() {
        otherUsers = UsersHandler.getUsersByContains(this);
        presentedUsers = new ListDataModel();
        if (otherUsers != null && otherUsers.size() > 0) {
            presentedUsers.setWrappedData(otherUsers);
        }
    }
    
    
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsersBean)) {
            return false;
        }

        UsersBean other = (UsersBean) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }


    
    
    
}
