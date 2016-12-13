package com.supinfo.qwirk.Database;

import com.supinfo.qwirk.Entity.Channel;
import com.supinfo.qwirk.Entity.ChannelType;
import com.supinfo.qwirk.Entity.Message;
import com.supinfo.qwirk.Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

/**
 * com.supinfo.qwirk.Database
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class MessageDTO {

    public static ArrayList<Message> getMessageFromChannel(ApplicationData applicationData, Channel channel) throws SQLException {
        Connection con = applicationData.getConnection();
        Statement stmt = null;
        ArrayList<Message> messages = new ArrayList<>();

        String query = "select * from Channel_Message  " +
                " where channel="+channel.getId()  ;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                messages.add(new Message(rs.getInt("id"),rs.getDate("date"),rs.getString("texte"),channel.getParticipantByID(rs.getInt("user")),channel));
            }

            channel.setMessages(messages);

        } finally {
            if (stmt != null) { stmt.close(); }
        }

        return messages;
    }


    public static ArrayList<Message> getLastMessageFromChannel(ApplicationData applicationData, Channel channel) throws SQLException {
        Connection con = applicationData.getConnection();
        Statement stmt = null;
        ArrayList<Message> messages = new ArrayList<>();
        Timestamp timestamp = new Timestamp(channel.getLastupdate().getTime());

        String query = "select * from Channel_Message  " +
                " where channel="+channel.getId() +" AND date >='"+timestamp +"'";
        System.out.println(channel.getLastupdate());
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                messages.add(new Message(rs.getInt("id"),rs.getDate("date"),rs.getString("texte"),channel.getParticipantByID(rs.getInt("user")),channel));
            }
            channel.addMessages(messages);
            if(!messages.isEmpty()){
                System.out.println("mouveaux message dans "+channel.getName()+" Nombre: "+messages.size());
            }
            channel.setLastupdate(new Date());
        } finally {
            if (stmt != null) { stmt.close(); }
        }

        return messages;
    }


    public static void getlastmessagesfromChannels(ApplicationData applicationData) throws SQLException {

           getLastMessageFromAllChannel(applicationData );


    }

    private static void getLastMessageFromAllChannel(ApplicationData applicationData) throws SQLException {
        Connection con = applicationData.getConnection();
        Statement stmt = null;
        Timestamp timestamp = new Timestamp(applicationData.getLastupdate().getTime());

        String query = "select Channel_Message.* from Channel_Message  "
                +" INNER join User_Channel on Channel_Message.channel=User_Channel.channel and User_Channel.user ="+applicationData.getCurrentUser().getId()+
                " where   date >='"+timestamp +"'";
        System.out.println(timestamp);
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Channel channel = applicationData.getData().getChannelByID(rs.getInt("channel"));
                channel.addMessage(new Message(rs.getInt("id"),rs.getDate("date"),rs.getString("texte"),channel.getParticipantByID(rs.getInt("user")),channel));

                System.out.println("mouveaux message dans "+channel.getName()+" Nombre: "+rs.getString("texte"));

            }
            applicationData.setLastupdate(new Date());

        } finally {
            if (stmt != null) { stmt.close(); }
        }

    }
}
