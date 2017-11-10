/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Niklas
 */
@NamedQueries({    
    @NamedQuery(name = "PersonalLog.findFromAll", query = "SELECT p FROM PersonalLog p WHERE p.sender.id = :Sender_id"), 
    @NamedQuery(name = "PersonalLog.findFromOneSender", query = "SELECT p FROM PersonalLog p WHERE  p.sender.id = :Sender_id"),
     @NamedQuery(name = "PersonalLog.findFromOneSenderName", query = "SELECT p FROM PersonalLog p WHERE  p.sender.username = :Sender_Name"),
})
@Entity
@Table(name="T_PersonalLog")
public class PersonalLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Date timePosted;
    
    @ManyToOne() 
    @JoinColumn(name="Sender_id")
    private Users sender;

    public PersonalLog() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }
    
    @Override
    public String toString() {
        return "PersonalLog{" + "id=" + id + ", text=" + text + ", timePosted=" + timePosted + '}';
    }
    
    
}
