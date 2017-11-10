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
 */
public class MessagesHandler {
    
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
    
    public static void setMessageIsRead(MessageBean bean) {
        MessagesDB.setMessageToIsRead(bean.getId());
    }
    
    public static Collection<MessageBean> getMessagesFromAll(UsersBean receiverBean) {
        Collection<Messages> messages = MessagesDB.getMessagesFromAll(receiverBean.getId());
        return convertToMessageBean(messages);
    }
    
    public static Collection<MessageBean> getMessagesFromOneSender(UsersBean receiverBean, Long sender_id) {
        Collection<Messages> messages = MessagesDB.getMessagesFromOneSender(receiverBean.getId(), sender_id);
        return convertToMessageBean(messages);
    }
    
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
