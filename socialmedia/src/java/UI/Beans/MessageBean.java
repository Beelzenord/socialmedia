/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Beans;

import BO.Handlers.MessagesHandler;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Niklas
 */
@ManagedBean
@SessionScoped
public class MessageBean {
    private int id;
    @ManagedProperty(value="#{sender}")
    private UsersBean sender;
    @ManagedProperty(value="#{receiver}")
    private UsersBean receiver;
    private String messageText;

    private Collection<MessageBean> messages;

    public MessageBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsersBean getSender() {
        return sender;
    }

    public void setSender(UsersBean sender) {
        this.sender = sender;
    }

    public UsersBean getReceiver() {
        return receiver;
    }

    public void setReceiver(UsersBean receiver) {
        this.receiver = receiver;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Collection<MessageBean> getMessages() {
        return messages;
    }

    public void setMessages(Collection<MessageBean> messages) {
        this.messages = messages;
    }
    
    public void getMessagesFromAll(int receiver_id) {
        messages = MessagesHandler.getMessagesFromAll(receiver_id);
    }
    
    public void addNewMessage() {
        MessagesHandler.addNewMessage(this);
    }
}
