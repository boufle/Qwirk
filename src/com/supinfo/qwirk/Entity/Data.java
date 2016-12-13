package com.supinfo.qwirk.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * com.supinfo.qwirk.Entity
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class Data implements Serializable {


    private ArrayList<Channel> channels = new ArrayList<>();
    private ArrayList<Channel> myChannels  = new ArrayList<>();
    private ArrayList<User> myContact  = new ArrayList<>();
    private Channel channelByID;

    public Data(ArrayList<Channel> channels, ArrayList<Channel> myChannels, ArrayList<User> myContact) {
        this.channels = channels;
        this.myChannels = myChannels;
        this.myContact = myContact;
    }


    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<Channel> channels) {
        this.channels = channels;
    }

    public ArrayList<Channel> getMyChannels() {
        return myChannels;
    }

    public void setMyChannels(ArrayList<Channel> myChannels) {
        this.myChannels = myChannels;
    }

    public ArrayList<User> getMyContact() {
        return myContact;
    }

    public void setMyContact(ArrayList<User> myContact) {
        this.myContact = myContact;
    }

    public Channel getChannelByID(Integer id) {
        for (Channel channel : channels) {
            if(channel.getId().equals(id)){
                return channel;
            }
        }
        return null;
    }


}
