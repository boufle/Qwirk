package com.supinfo.qwirk.Database;

import com.supinfo.qwirk.CustomException.SendMessageExeption;
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

    public static Message sendmessage(ApplicationData applicationData , Message message) throws  SendMessageExeption {
        try {
            Connection con = applicationData.getConnection();

            Statement stmt = null;


            String sql = "INSERT INTO `Channel_Message` (`id`, `date`, `texte`, `user`, `channel`) VALUES (NULL, CURRENT_TIMESTAMP, '"+ message.getTexte()+"', '"+message.getUser().getId()+"', '"+message.getChannel().getId()+"')";



            try {
                stmt = con.createStatement();
                int rs = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);;
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        message.setId((int) generatedKeys.getLong(1));
                    }
                    else {
                        throw new SendMessageExeption("Creating user failed, no ID obtained", message);

                    }
                }
            } catch (SQLException e) {
                throw new SendMessageExeption("Erreur", message);
            } finally {
                if (stmt != null) {
                        stmt.close();
                    }
                }
            }catch (SQLException e) {
                throw new SendMessageExeption("Erreur", message);
            }


        return message;
    }


    private static void getLastMessageFromAllChannel(ApplicationData applicationData) throws SQLException {
        Connection con = applicationData.getConnection();
        Statement stmt = null;

        StringBuilder stringBuilder = new StringBuilder();

        if(applicationData.getData().getMyChannels().size()>0){
            stringBuilder.append( " AND channel in (");
            for (Channel channel : applicationData.getData().getMyChannels()) {
                stringBuilder.append(channel.getId()).append(",") ;
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append( ") ");

        }else {
            return;
        }

        String query = "select Now() as dateserveur,Channel_Message.* from Channel_Message  "+

                " where   date >='"+applicationData.getLastupdate() +"'" +stringBuilder.toString();

        Timestamp date = null;
       // System.out.println(applicationData.getLastupdate());
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Channel channel = applicationData.getData().getChannelByID(rs.getInt("channel"));
                channel.addMessage(new Message(rs.getInt("id"),rs.getDate("date"),rs.getString("texte"),channel.getParticipantByID(rs.getInt("user")),channel));
                date = rs.getTimestamp("dateserveur");
                System.out.println("mouveaux message dans "+channel.getName()+" Nombre: "+rs.getString("texte"));

            }
            if(date==null){
               date =  DateDTO.getdateServeur(applicationData);
            }
            applicationData.setLastupdate(date);

            //System.out.println(applicationData.getLastupdate());

        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
}
