package com.supinfo.qwirk.Database;

 import com.supinfo.qwirk.Entity.Channel;
 import com.supinfo.qwirk.Entity.ChannelType;
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
public class ChanelDTO {

    public static ArrayList<Channel> getChannels(ApplicationData applicationData, Integer channelType) throws SQLException {
        Connection con = applicationData.getConnection();
        Statement stmt = null;
        ArrayList<Channel> channels = new ArrayList<>();

        String where ="";
        String where2 ="";

        //Si l'utilisateur veut ses channels
        if(channelType.equals(ChannelType.MINE)){
            where = "INNER join User_Channel on Channel.id=User_Channel.channel and User_Channel.user ="+applicationData.getCurrentUser().getId();
            where2 ="1=1";
        }
        if(channelType.equals(ChannelType.PUBLIC)){
            where2 = "type=1";
        }
        if(channelType.equals(ChannelType.PRIVATE)){
            where2 = "type=2";
        }

        String query = "select * from Channel  " +
                where +
                " where "+where2  ;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                channels.add(new Channel(rs.getInt("id"),rs.getString("Name"),rs.getString("Description"),rs.getInt("type")));
            }
        } finally {
            if (stmt != null) { stmt.close(); }
        }


        for (Channel channel : channels) {
            getparticipants(applicationData,channel);
            MessageDTO.getMessageFromChannel(applicationData,channel);
        }


        return channels;
    }


    public static ArrayList<User> getparticipants(ApplicationData applicationData , Channel channel) throws SQLException {
        Connection con = applicationData.getConnection();
        Statement stmt = null;
        ArrayList<User> users = new ArrayList<>();
        String query = "select utilisateur.* from User_Channel " +
                "INNER join User utilisateur on User_Channel.user = utilisateur.id " +
                "where channel="+channel.getId()  ;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),rs.getString("email"),rs.getString("pseudo"),rs.getString("profil_icon")));
            }
        } finally {
            if (stmt != null) { stmt.close(); }
        }


        channel.setParticipants(users);

        return users;
    }


}
