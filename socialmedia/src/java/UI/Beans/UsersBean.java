/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Beans;

import BO.Entity.Users;
import BO.Handlers.PersonalLogHandler;
import BO.Handlers.UsersHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fauzianordlund
 */
@ManagedBean
@SessionScoped
public class UsersBean {
    private Long id;
    private String otherLogUsername;
    private String username;
    private String pass;
    private String occupation;
    private String searchForUser;
    private List<UsersBean> usersSelectListBeans;
    private Collection<PersonalLogBean> personalLogs;
    private Collection<PersonalLogBean> otherUsersLogs;
    
    /**
     * Creates a new instance of UserBean
     */
    public UsersBean() {
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

    public String getOtherLogUsername() {
        return otherLogUsername;
    }

    public void setOtherLogUsername(String otherLogUsername) {
        this.otherLogUsername = otherLogUsername;
    }

    public List<UsersBean> getUsersSelectListBeans() {
        return usersSelectListBeans;
    }

    public void setUsersSelectListBeans(List<UsersBean> usersSelectListBeans) {
        this.usersSelectListBeans = usersSelectListBeans;
    }

    public Collection<PersonalLogBean> getOtherUsersLogs() {
        return otherUsersLogs;
    }

    public void setOtherUsersLogs(Collection<PersonalLogBean> otherUsersLogs) {
        this.otherUsersLogs = otherUsersLogs;
    }

    public Collection<PersonalLogBean> getPersonalLogs() {
        return personalLogs;
    }

    public void setPersonalLogs(Collection<PersonalLogBean> personalLogs) {
        this.personalLogs = personalLogs;
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
    
    public void getAllUsers() {
        UsersHandler.getAllUsers();
    }
    
    public  Collection<PersonalLogBean> getAllLogs(){
       this.personalLogs = PersonalLogHandler.getPostsFromOneUser(username);
       return personalLogs;
    }
    
    public  Collection<PersonalLogBean> getLogsOfOtherUser(){
       this.otherUsersLogs = PersonalLogHandler.getPostsFromOneUser(username);
       return otherUsersLogs;
    }
    
    public void getUsersByContains() {
        if (searchForUser.length() > 0) {
            Collection<UsersBean> tmp = UsersHandler.getUsersByContains(this);
            usersSelectListBeans = new ArrayList();
            for (UsersBean b : tmp) {
                usersSelectListBeans.add(b);
            }
        }
    }
    
    public void findLogsForOtherUser() {
        this.otherUsersLogs = PersonalLogHandler.getPostsFromOneUser(otherLogUsername);
    
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
