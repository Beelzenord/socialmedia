/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Niklas
 */
@NamedQueries({    
    @NamedQuery(name = "Messages.findFromAll", query = "SELECT m FROM Messages m WHERE m.receiver.id = :Receiver_id"), 
    @NamedQuery(name = "Messages.findFromOneSender", query = "SELECT m FROM Messages m WHERE m.receiver.id = :Receiver_id AND m.sender.id = :Sender_id"),
})
@Entity
@Table(name="T_Messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne() 
    @JoinColumn(name="Sender_id")
    private Users sender;
    @ManyToOne() 
    @JoinColumn(name="Receiver_id")
    private Users receiver;
    private String messageText;
    private boolean isRead;
    private boolean isDeleted;
    private Date timeSent;

    public Messages() {
    }

    public Messages(Users sender, Users receiver, String messageText, boolean isRead, boolean isDeleted, Date timeSent) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageText = messageText;
        this.isRead = isRead;
        this.isDeleted = isDeleted;
        this.timeSent = timeSent;
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

    public Users getReceiver() {
        return receiver;
    }

    public void setReceiver(Users receiver) {
        this.receiver = receiver;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }
    
    
}
