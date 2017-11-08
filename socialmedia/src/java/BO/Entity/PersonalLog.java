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
import javax.persistence.Table;

/**
 *
 * @author Niklas
 */
@Entity
@Table(name="T_PersonalLog")
public class PersonalLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Date timePosted;

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

    @Override
    public String toString() {
        return "PersonalLog{" + "id=" + id + ", text=" + text + ", timePosted=" + timePosted + '}';
    }
    
    
}
