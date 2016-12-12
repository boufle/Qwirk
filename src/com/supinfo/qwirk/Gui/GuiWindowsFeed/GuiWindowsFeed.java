package com.supinfo.qwirk.Gui.GuiWindowsFeed;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiWindowsFeed extends JPanel {

    public GuiWindowsFeed(){

        prepareFeed(10);

    }

    public void prepareFeed(int numberOfFeed){

        setLayout(new GridLayout(0,3,5,5));
        for (int i = 0; i < numberOfFeed; i++){

            GuiFeed guiFeed = new GuiFeed();
            add(guiFeed);
        }
    }
}
