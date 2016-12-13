package com.supinfo.qwirk;

import com.supinfo.qwirk.Database.ApplicationData;
import com.supinfo.qwirk.Database.UserDTO;
import com.supinfo.qwirk.Entity.User;
import com.supinfo.qwirk.Frame.FrameLoginScreen;
import com.supinfo.qwirk.Frame.FrameMainScreen;
import com.supinfo.qwirk.Gui.utils.utils;

import java.sql.SQLException;

/**
 * Created by Boufle on 12/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationData applicationData = new ApplicationData();
        applicationData.connect();

        FrameLoginScreen frameMainScreen = new FrameLoginScreen(applicationData);


        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                applicationData.logout();
                applicationData.stopbase();
            }
        }));
        utils.getInstance();
       // applicationData.stopbase();
    }
}
