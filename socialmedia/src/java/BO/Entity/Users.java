/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 *
 * @author fauzianordlund
 */
@NamedQueries({    
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),    
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),    
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.username = :name"),    
})
@Entity
@Table(name="T_Users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String pass;
    private String occupation;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")    
    @OrderBy("timesent DESC")
    private Collection<Messages> messages;
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)    
    @JoinTable(name="T_Friends",  joinColumns = {         
        @JoinColumn(name="user_id2", nullable=false, updatable=false) 
    }, inverseJoinColumns = {         
        @JoinColumn(name="user_id1", nullable=false, updatable=false) 
    })   
    private Set<Users> usersForUserId;

    public Users() {
        this.messages = new ArrayList();
    }
    
    public Set<Users> getUsersForUserId() {
        return this.usersForUserId;
    }

    public void setUsersForUserId(Set<Users> usersForUserId) {
        this.usersForUserId = usersForUserId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } public String getUsername() {
        return username;
    }

    public Collection<Messages> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Messages> messages) {
        this.messages = messages;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        
        return hash;
    }


    @Override
    public String toString() {
        return "entity.Users[ id=" + id + " ]";
    }
    
}
