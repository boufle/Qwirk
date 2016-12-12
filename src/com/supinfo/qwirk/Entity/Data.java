package com.supinfo.qwirk.Entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * com.supinfo.qwirk.Entity
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class Data implements Serializable {

    private ArrayList<Channel> channels = new ArrayList<>();
    private ArrayList<Channel> myChannels  = new ArrayList<>();
    private ArrayList<User> myContact  = new ArrayList<>();

    public Data(ArrayList<Channel> channels, ArrayList<Channel> myChannels, ArrayList<User> myContact) {
        this.channels = channels;
        this.myChannels = myChannels;
        this.myContact = myContact;
    }
}
