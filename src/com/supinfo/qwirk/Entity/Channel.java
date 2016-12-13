package com.supinfo.qwirk.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * com.supinfo.qwirk.Entity
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class Channel implements Serializable{

    Integer id ;
    String Name;
    String Description;
    Integer type;
    private Date lastupdate= new Date();

    ArrayList<User> participants = new ArrayList();
    ArrayList<Message> messages = new ArrayList();

    public Channel(Integer id, String name, String description, int type) {
        this.id = id;
        this.Name = name;
        this.Description = description;
        this.type = type;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<User> participants) {
        this.participants = participants;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public User getParticipantByID(Integer id){
        for (User participant : participants) {
            if(participant.getId().equals(id)){
                return participant;
            }
        }
        return null;
    }

    public void addMessages(ArrayList<Message> messages) {
        getMessages().addAll(messages);
    }

    public void addMessage(Message message) {
        getMessages().add(message);
    }
}
