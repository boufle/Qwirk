package com.supinfo.qwirk.Database;

import com.supinfo.qwirk.Entity.Channel;
import com.supinfo.qwirk.Entity.ChannelType;
import com.supinfo.qwirk.Entity.Message;
import com.supinfo.qwirk.Entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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




}
