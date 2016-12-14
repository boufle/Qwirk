package com.supinfo.qwirk.Database;

import com.supinfo.qwirk.Entity.EtatUser;
import com.supinfo.qwirk.Entity.User;
import com.supinfo.qwirk.Utils.MD5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * com.supinfo.qwirk.Database
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class UserDTO {

    public static User login(ApplicationData applicationData , String email, String mdp) throws SQLException {
        Connection con = applicationData.getConnection();

        Statement stmt = null;
        User user1 = new User();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from User where email='"+email+"' and pass='"+ MD5.MD5(mdp)+"'");

        int rowCount = 0;
        while ( rs.next() )
        {
            user1.setId(rs.getInt("id"));
            user1.setEmail(rs.getString("email"));
            user1.setPseudo(rs.getString("pseudo"));
            user1.setProfil_Icon(rs.getString("profil_icon"));

            // Process the row.
            rowCount++;
        }
        if (stmt != null) { stmt.close(); }

        if(rowCount != 1 ){
            return null;
        }

        return user1;

    }


    public static User register(ApplicationData applicationData , String email, String mdp,String pseudo,String profil_Icon) throws SQLException {
        Connection con = applicationData.getConnection();

        Statement stmt = null;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from User where email='"+email+"' and pass='"+ MD5.MD5(mdp)+"'");

        int rowCount = 0;
        while ( rs.next() )
        {
            rowCount++;
        }
        if (stmt != null) { stmt.close(); }

        if(rowCount != 0 ){
            return null;
        }else{


            stmt = con.createStatement();
            stmt.executeQuery("INSERT INTO `orleansaqwirk`.`User` (`id`, `email`, `pseudo`, `pass`, `profil_icon`, `etat`) VALUES (NULL, '"+email+"', '"+ MD5.MD5(mdp)+"', '"+ pseudo +"', '"+ profil_Icon +"', '0')");
            if (stmt != null) { stmt.close(); }

            return login(applicationData,email,mdp);

        }

    }

    public static ArrayList<User> getContacts(ApplicationData applicationData) throws SQLException {
        Connection con = applicationData.getConnection();

        Statement stmt = null;
        ArrayList<User> users = new ArrayList<>();

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select utilisateur.* from User_Contact " +
                " INNER join User as utilisateur on User_Contact.User = utilisateur.id " +
                " where User_Contact.User="+applicationData.getCurrentUser().getId()+" or User_Contact.User2="+applicationData.getCurrentUser().getId());

        while ( rs.next() )
        {
            User user1 = new User();
            user1.setId(rs.getInt("id"));
            user1.setEmail(rs.getString("email"));
            user1.setPseudo(rs.getString("pseudo"));
            user1.setProfil_Icon(rs.getString("profil_icon"));

            users.add(user1);
        }
        if (stmt != null) { stmt.close(); }

        return users;
    }

    public static void updateStatus(ApplicationData applicationData , Integer etatUser) throws SQLException {

        User currentUser = applicationData.getCurrentUser();
        if (currentUser!=null) {
            String query = "UPDATE `User` SET `etat` = " + etatUser + " WHERE `User`.`id` = " + applicationData.getCurrentUser().getId();
            Connection con = applicationData.getConnection();
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
        }

    }



}
