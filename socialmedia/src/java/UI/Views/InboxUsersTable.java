/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Views;

/**
 *
 * @author Niklas
 */
public class InboxUsersTable {
    private String username;
    private Long id;
    private int nrOfUnreadMessage;

    public InboxUsersTable(String username, Long id, int nrOfUnreadMessage) {
        this.username = username;
        this.id = id;
        this.nrOfUnreadMessage = nrOfUnreadMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNrOfUnreadMessage() {
        return nrOfUnreadMessage;
    }

    public void setNrOfUnreadMessage(int nrOfUnreadMessage) {
        this.nrOfUnreadMessage = nrOfUnreadMessage;
    }

}
