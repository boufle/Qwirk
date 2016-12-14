package com.supinfo.qwirk.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * com.supinfo.qwirk.Entity
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class Message implements Serializable{

    Integer id ;
    Date date;
    String texte;
    User user;
    Channel Channel;
    Boolean read = true;

    public Message(Integer id, java.sql.Date date, String texte, User user, Channel channel) {
        this.id = id;
        this.date = date;
        this.texte = texte;
        this.user = user;
        this.Channel = channel;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public com.supinfo.qwirk.Entity.Channel getChannel() {
        return Channel;
    }

    public void setChannel(com.supinfo.qwirk.Entity.Channel channel) {
        Channel = channel;
    }
}
