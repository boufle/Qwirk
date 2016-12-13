package com.supinfo.qwirk.Frame;

import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBar;
import com.supinfo.qwirk.Gui.GuiWindowsFeed.GuiWindowsFeed;
import com.supinfo.qwirk.Gui.utils.GuiPanelHtml;
import com.supinfo.qwirk.Gui.utils.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 13/12/2016.
 */
public class DialogHtmlScreen extends JFrame {


    protected GuiWindowsBar guiWindowsBar = new GuiWindowsBar();
    protected GuiPanelHtml guiPanelHtml = new GuiPanelHtml();
    // protected Resizer cr = new Resizer();

    private DialogHtmlScreen(){
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
        add(guiPanelHtml, BorderLayout.CENTER);
    }

    private static DialogHtmlScreen INSTANCE = null;

    public static synchronized DialogHtmlScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DialogHtmlScreen();
        }
        return INSTANCE;
    }

    public GuiWindowsBar getGuiWindowsBar() {
        return guiWindowsBar;
    }
}

