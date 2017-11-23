/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO.Entity;

import BO.Handlers.MessagesHandler;
import UI.Beans.MessageBean;
import UI.Beans.UsersBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Niklas
 * Testing the Message entity, message bean and the MessageHandler.
 * See InitiateDB to set tables and tuples into a fresh database.
 */
public class MessagesTest {
    
    public MessagesTest() {
    }

    /**
     * Testing the creation of a Message.
     */
    @Test
    public void TestCreateMessage() {
        MessageBean b = new MessageBean();
        b.setMessageText("test message");
        UsersBean u1 = new UsersBean();
        u1.setId(new Long(1));
        UsersBean u2 = new UsersBean();
        u2.setId(new Long(2));
        b.setReceiver(u2);
        b.setUsersBean(u1);
        MessagesHandler.addNewMessage(b);
    }
    
    /**
     * Testing finding messages directed to one user from a specific sender.
     * Find messages from user 1 to user 2. 
     * This should be the first message in the database with message "to u2 from u1".
     */
    @Test
    public void TestFindMessagesToOneReceiverFromOneSender() {
        UsersBean receiverBean = new UsersBean();
        receiverBean.setId(new Long(2));
        Collection<MessageBean> messages = MessagesHandler.getMessagesFromOneSender(receiverBean, new Long(1));
        ArrayList<MessageBean> list = new ArrayList();
        for (MessageBean b : messages) {
            list.add(b);
        }
        assertEquals(new Long(1), list.get(0).getId());
        assertEquals("to u2 from u1", list.get(0).getMessageText());
    }
    
    /**
     * Testing finding messages directed to one user from all user.
     * Receiver should be user 2 the second message in the database 
     * with message text "to 2 from u3".
     */
    @Test
    public void TestFindAllMessagesFromAllToOneReceiver() {
        UsersBean receiverBean = new UsersBean();
        receiverBean.setId(new Long(2));
        Collection<MessageBean> messages = MessagesHandler.getMessagesFromAll(receiverBean);
        ArrayList<MessageBean> list = new ArrayList();
        for (MessageBean b : messages) {
            list.add(b);
        }
        assertEquals(new Long(2), list.get(1).getId());
        assertEquals("to u2 from u3", list.get(1).getMessageText());
    }
    
    
}
