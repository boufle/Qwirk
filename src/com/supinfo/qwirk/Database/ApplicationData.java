package com.supinfo.qwirk.Database;

import com.jcraft.jsch.JSchException;
import com.supinfo.qwirk.CustomException.SendMessageExeption;
import com.supinfo.qwirk.Entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * com.supinfo.qwirk.Database
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class ApplicationData {

    private static ApplicationData applicationData=null;


    DatabaseConnection databaseConnection = null;
    private User currentUser = null;

    Data data = null;


    Timer notimeoutDB = new Timer();
    private Timestamp lastupdate = null;

    private ApplicationData() {

        databaseConnection = new DatabaseConnection();
    }

    public void connect(){
        try {
            if(!databaseConnection.isconected()){
                databaseConnection.connect();

                notimeoutDB.schedule( new TimerTask() {
                    public void run() {
                        try {
                            databaseConnection.notimeout();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, 50000, 50000);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void logout(){

        //Si le mec est co on change son statut
        try {
            if(getCurrentUser()!=null){
                UserDTO.updateStatus(this, EtatUser.HORSLIGNE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void stopbase(){
        try {
            notimeoutDB.cancel();
            databaseConnection.deconexionbase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        if(databaseConnection.isconected()){
            return databaseConnection.conn;
        }
        return null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Data getData() {
        return data;
    }

    public void setCurrentUser(User currentUser) throws SQLException {
        //appele lors de la connexion
        this.currentUser = currentUser;
        UserDTO.updateStatus(this, EtatUser.ENLIGNE);

        //chargement de toute les données de l'utilisateur
        ArrayList<Channel> channels = ChanelDTO.getChannels(this, ChannelType.PUBLIC);
        ArrayList<Channel> myChannels = ChanelDTO.getChannels(this, ChannelType.MINE);
        ArrayList<User> myContact = UserDTO.getContacts(this);

        this.data = new Data(channels,myChannels,myContact);

     /*   try {
            MessageDTO.sendmessage(this,new Message(null,null,"yehah", this.getCurrentUser(), myChannels.get(0)));
        } catch (SendMessageExeption sendMessageExeption) {
            sendMessageExeption.printStackTrace();
        }*/

        startupdateMessages();
    }



    public void startupdateMessages(){

        try {
           lastupdate= DateDTO.getdateServeur(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //notimeoutDB.cancel();

        notimeoutDB.schedule( new TimerTask() {
                public void run() {
                    try {
                        MessageDTO.getlastmessagesfromChannels(ApplicationData.this);
                        //databaseConnection.notimeout();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 2000);
    }


    public Timestamp getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Timestamp lastupdate) {
        this.lastupdate = lastupdate;
    }
    public synchronized static ApplicationData getInstance(){
        if(applicationData==null){
            applicationData = new ApplicationData();
            applicationData.connect();

        }
        return applicationData;
    }
}
