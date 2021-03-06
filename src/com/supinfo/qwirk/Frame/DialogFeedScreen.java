package com.supinfo.qwirk.Frame;

import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBar;
import com.supinfo.qwirk.Gui.GuiWindowsFeed.GuiWindowsFeed;
import com.supinfo.qwirk.Gui.utils.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class DialogFeedScreen extends JFrame {


    protected GuiWindowsBar guiWindowsBar = new GuiWindowsBar();
    protected GuiWindowsFeed guiWindowsFeed = new GuiWindowsFeed();
   // protected Resizer cr = new Resizer();

    private DialogFeedScreen(){
        setUndecorated(true);
        setSize(1400,800);
        setLocation(utils.getInstance().getPosX(), utils.getInstance().getPosY());
        setLayout(new BorderLayout());
        init();
     //   cr.registerComponent(this);
        setVisible(true);

    }

    public void init(){

        add(guiWindowsBar, BorderLayout.LINE_START);
        add(guiWindowsFeed, BorderLayout.CENTER);
    }

    private static DialogFeedScreen INSTANCE = null;

    public static synchronized DialogFeedScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DialogFeedScreen();
        }
        return INSTANCE;
    }

    public GuiWindowsBar getGuiWindowsBar() {
        return guiWindowsBar;
    }
}
