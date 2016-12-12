package com.supinfo.qwirk.Database;

import com.jcraft.jsch.JSchException;

import java.sql.SQLException;

/**
 * com.supinfo.qwirk.Database
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class ApplicationData {
    DatabaseConnection databaseConnection = null;
    public ApplicationData() {
        try {
              databaseConnection = new DatabaseConnection();
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
    public void stopbase(){
        try {
            databaseConnection.deconexionbase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 }
