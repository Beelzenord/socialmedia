/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Handlers;

import BO.Entity.Messages;
import BO.Entity.Users;
import DB.MessagesDB;
import UI.Beans.MessageBean;
import UI.Beans.UsersBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Niklas
 * The MessagesHandler is used as a transition between viewmodels and database entities.
 * There are methods to create new messages, finding messages from specific receivers and sender. 
 * A message can also be set to IsRead = true.
*/
public class MessagesHandler {
    
    /**
     * Add a new message to the database. The MessageBean should contain 
     * the ID of the receiver and sender, and a message text. A new Message entity
     * will be created using the information in the bean and will then be sent 
     * to MessagesDB to be inserted into the database.
     * @param bean The MessageBean containing the information of the new Message.
     */
    public static void addNewMessage(MessageBean bean) {
        Users receiver = UsersHandler.getUserById(bean.getReceiver());
        Users sender = UsersHandler.getUserById(bean.getUsersBean());
        Messages m = new Messages();
        m.setMessageText(bean.getMessageText());
        m.setReceiver(receiver);
        m.setSender(sender);
        m.setIsRead(false);
        m.setIsDeleted(false);
        m.setTimeSent(new Date());
        MessagesDB.addNewMessage(m);
    }
    
    /**
     * Set a message to IsRead = true.
     * @param bean The bean of the Message to be set to IsRead = true.
     */
    public static void setMessageIsRead(MessageBean bean) {
        MessagesDB.setMessageToIsRead(bean.getId());
    }
    
    /**
     * This method finds all messages directed to a specific user. 
     * @param receiverBean The bean of the receiver user. 
     * @return A Collection of all Messages directed at the specified user. 
     */
    public static Collection<MessageBean> getMessagesFromAll(UsersBean receiverBean) {
        Collection<Messages> messages = MessagesDB.getMessagesFromAll(receiverBean.getId());
        return convertToMessageBean(messages);
    }
    
    /**
     * This method finds all messages directed to a specific user from a specific user.
     * @param receiverBean The bean of the receiver user.
     * @param sender_id The ID of the sender user.
     * @return A Collection of all Messages directed at the receiver user from the sender user.
     */
    public static Collection<MessageBean> getMessagesFromOneSender(UsersBean receiverBean, Long sender_id) {
        Collection<Messages> messages = MessagesDB.getMessagesFromOneSender(receiverBean.getId(), sender_id);
        return convertToMessageBean(messages);
    }
    
    /**
     * Converts a collection of entity Messages to a Collection of MessageBean.
     * @param messages The Collection of entity Messages to be converted.
     * @return A Collection of MessageBean. 
     */
    private static Collection<MessageBean> convertToMessageBean(Collection<Messages> messages) {
        Collection<MessageBean> messageBean = new ArrayList();
        for (Messages m : messages) {
            if (!m.getIsDeleted()) {
                MessageBean tmp = new MessageBean();
                tmp.setId(m.getId());
                tmp.setMessageText(m.getMessageText());
                tmp.setPreview(StringUtils.abbreviate(m.getMessageText(), 40));
                tmp.setIsDeleted(m.getIsDeleted());
                tmp.setIsRead(m.getIsRead());
                tmp.setTimeSent(m.getTimeSent());
                UsersBean receiver = new UsersBean();
                receiver.setId(m.getReceiver().getId());
                receiver.setUsername(m.getReceiver().getUsername());
                tmp.setReceiver(receiver);
                UsersBean sender = new UsersBean();
                sender.setId(m.getSender().getId());
                sender.setUsername(m.getSender().getUsername());
                tmp.setSender(sender);
                messageBean.add(tmp);
            }
        }
        return messageBean;
    }
}
