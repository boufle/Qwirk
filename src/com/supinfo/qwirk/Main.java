package com.supinfo.qwirk;

import com.supinfo.qwirk.Database.ApplicationData;
import com.supinfo.qwirk.Frame.FrameMainScreen;

/**
 * Created by Boufle on 12/12/2016.
 */
public class Main {
    public static void main(String[] args) {

        FrameMainScreen frameMainScreen = new FrameMainScreen();

        ApplicationData applicationData = new ApplicationData();
        applicationData.stopbase();
    }
}
