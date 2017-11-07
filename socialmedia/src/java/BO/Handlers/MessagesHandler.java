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

/**
 *
 * @author Niklas
 */
public class MessagesHandler {
    
    public static void addNewMessage(MessageBean bean) {
        Users receiver = UsersHandler.getUserById(bean.getReceiver());
        Users sender = UsersHandler.getUserById(bean.getSender());
        Messages m = new Messages();
        m.setMessageText(bean.getMessageText());
        m.setReceiver(receiver);
        m.setSender(sender);
        MessagesDB.addNewMessage(m);
    }
    
    public static Collection<MessageBean> getMessagesFromAll(int receiver_id) {
        Collection<Messages> messages = MessagesDB.getMessagesFromAll(receiver_id);
        return convertToMessageBean(messages);
    }
    
    public static Collection<MessageBean> getMessagesFromOneSender(int receiver_id, int sender_id) {
        Collection<Messages> messages = MessagesDB.getMessagesFromOneSender(receiver_id, sender_id);
        return convertToMessageBean(messages);
    }
    
    private static Collection<MessageBean> convertToMessageBean(Collection<Messages> messages) {
        Collection<MessageBean> messageBean = new ArrayList();
        for (Messages m : messages) {
            MessageBean tmp = new MessageBean();
            tmp.setId(m.getId());
            tmp.setMessageText(m.getMessageText());
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
        return messageBean;
    }
}
