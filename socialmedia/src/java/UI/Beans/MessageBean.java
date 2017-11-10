/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Beans;

import BO.Handlers.MessagesHandler;
import BO.Handlers.UsersHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Niklas
 */
@ManagedBean
@SessionScoped
public class MessageBean {
    private Long id;
    private Long receiverID;
    private UsersBean sender;
    private UsersBean receiver;
    private String messageText;
    private List<UsersBean> usersSelectListBeans;
    @ManagedProperty(value="#{usersBean}")
    private UsersBean usersBean;

    private Collection<MessageBean> messages;

    public MessageBean() {
    }

    public void resetInfo() {
        id = new Long(-1);
        receiverID = new Long(-1);
        sender = null;
        receiver = null;
        messageText = ""; 
        usersSelectListBeans = null;
    }
    
    public Long getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(Long receiverID) {
        this.receiverID = receiverID;
    }

    public List<UsersBean> getUsersSelectListBeans() {
        return usersSelectListBeans;
    }

    public void setUsersSelectListBeans(List<UsersBean> usersSelectListBeans) {
        this.usersSelectListBeans = usersSelectListBeans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public UsersBean getUsersBean() {
        return usersBean;
    }

    public void setUsersBean(UsersBean usersBean) {
        this.usersBean = usersBean;
    }
    
    public void getMessagesFromAll(Long receiver_id) {
        messages = MessagesHandler.getMessagesFromAll(receiver_id);
    }
    
    public void addNewMessage() {
        MessagesHandler.addNewMessage(this);
    }
    
    public void getUsersByContains() {
        if (usersBean.getSearchForUser().length() > 0) {
            Collection<UsersBean> tmp = UsersHandler.getUsersByContains(usersBean);
            usersSelectListBeans = new ArrayList();
            for (UsersBean b : tmp) {
                usersSelectListBeans.add(b);
            }
        }
    }
    
    public void sendMessageToSelectedUser() {
        UsersBean b = new UsersBean();
        b.setId(receiverID);
        receiver = b;
        addNewMessage();
        usersBean.setSearchForUser("");
        setMessageText("");
        usersSelectListBeans.clear();
    }
}
