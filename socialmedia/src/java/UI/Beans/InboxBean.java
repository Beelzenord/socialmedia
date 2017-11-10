/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Beans;

import BO.Handlers.MessagesHandler;
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
public class InboxBean {
    private Long senderID;
    private DataModel<MessageBean> messageTable;
    @ManagedProperty(value="#{usersBean}")
    private UsersBean usersBean;
    @ManagedProperty(value="#{messageBean}")
    private MessageBean messageBean;
    private List<UsersBean> usersWhoSentMessagesToThisUser;
    private String singleMessage;
    
    public void getMessagesFromOneSender() {
        Collection<MessageBean> tmp = MessagesHandler.getMessagesFromOneSender(usersBean, senderID);
        messageTable = new ListDataModel<MessageBean>();
        if (tmp.size() > 0) {
            messageTable.setWrappedData(tmp);
        }
    }
    
    public void presentSingleMessage() {
        MessageBean b = (MessageBean)messageTable.getRowData();
        singleMessage = b.getMessageText();
        if (!b.getIsRead()) {
            MessagesHandler.setMessageIsRead(b);
            b.setIsRead(true);
        }
    }

    public void getSendersToThisUser() {
        Collection<MessageBean> tmp = MessagesHandler.getMessagesFromAll(usersBean);
        usersWhoSentMessagesToThisUser = new ArrayList();
        for (MessageBean b : tmp) {
            if (!usersWhoSentMessagesToThisUser.contains(b.getSender()))
                usersWhoSentMessagesToThisUser.add(b.getSender());
        }
    }

    public UsersBean getUsersBean() {
        return usersBean;
    }

    public void setUsersBean(UsersBean usersBean) {
        this.usersBean = usersBean;
    }

    public MessageBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessageBean messageBean) {
        this.messageBean = messageBean;
    }

    public Long getSenderID() {
        return senderID;
    }

    public void setSenderID(Long senderID) {
        this.senderID = senderID;
    }

    public List<UsersBean> getUsersWhoSentMessagesToThisUser() {
        return usersWhoSentMessagesToThisUser;
    }

    public void setUsersWhoSentMessagesToThisUser(List<UsersBean> usersWhoSentMessagesToThisUser) {
        this.usersWhoSentMessagesToThisUser = usersWhoSentMessagesToThisUser;
    }

    public DataModel<MessageBean> getMessageTable() {
        return messageTable;
    }

    public void setMessageTable(DataModel<MessageBean> messageTable) {
        this.messageTable = messageTable;
    }

    public String getSingleMessage() {
        return singleMessage;
    }

    public void setSingleMessage(String singleMessage) {
        this.singleMessage = singleMessage;
    }

}
