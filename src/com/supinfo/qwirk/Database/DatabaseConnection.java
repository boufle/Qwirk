package com.supinfo.qwirk.Database;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.supinfo.qwirk.Entity.User;
import com.supinfo.qwirk.Utils.MyBase64;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * com.supinfo.qwirk.Database
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class DatabaseConnection {

    Session session = null;
    Connection conn = null;

    public DatabaseConnection()  {

    }
    public void connect() throws SQLException, ClassNotFoundException, JSchException, IllegalAccessException, InstantiationException {
        short lport = 5656;
        String rhost = "orleansaqwirk.mysql.db";
        String host = "ftp.orleansactu.fr";
        short rport = 3306;
        String user = "orleansa";
        String password = new String(MyBase64.decode("b3JsZWFuc2Z0cDQ1"), StandardCharsets.UTF_8);
        String dbuserName = "orleansaqwirk";
        String dbpassword = new String(MyBase64.decode("QUs1NDNxcnA="), StandardCharsets.UTF_8);
        String url = "jdbc:mysql://localhost:" + lport + "/orleansaqwirk?autoReconnect=true";
        String driverName = "com.mysql.jdbc.Driver";
        conn = null;
        session = null;

        Properties e = new Properties();
        e.put("StrictHostKeyChecking", "no");
        JSch jsch = new JSch();
        session = jsch.getSession(user, host, 22);
        session.setPassword(password);
        session.setConfig(e);
        session.connect();
        System.out.println("Connected");
        int assinged_port = session.setPortForwardingL(lport, rhost, rport);
        System.out.println("localhost:" + assinged_port + " -> " + rhost + ":" + rport);
        System.out.println("Port Forwarded");
        Class.forName(driverName).newInstance();
        conn = DriverManager.getConnection(url, dbuserName, dbpassword);
        System.out.println("Database connection established");
        System.out.println("DONE");
    }

    public void deconexionbase() throws SQLException {
        if(conn != null && !conn.isClosed()) {
            System.out.println("Closing Database Connection");
            conn.close();
        }

        if(session != null && session.isConnected()) {
            System.out.println("Closing SSH Connection");
            session.disconnect();
        }
    }

    public boolean isconected() throws SQLException {
        if(conn != null && !conn.isClosed() && session != null && session.isConnected()) {
           return true;
        }
        return false;
    }


    public void notimeout() throws SQLException {


        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id from User  where 1=2");


        if (stmt != null) { stmt.close(); }


    }
}
