package com.supinfo.qwirk.Frame;

import com.supinfo.qwirk.Gui.GuiChat;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * Created by Boufle on 12/12/2016.
 */
public class DialogFeedScreen extends JDialog {


    protected GuiWindowsBar guiWindowsBar = new GuiWindowsBar();
    protected GuiChat guiChat = new GuiChat();

    private DialogFeedScreen(){
        setUndecorated(true);
        setSize(1200,800);
/*        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
            }
        });*/
        setLayout(new BorderLayout());
        init();
        setVisible(true);
    }

    public void init(){

        add(guiChat, BorderLayout.LINE_END);
        add(guiWindowsBar, BorderLayout.LINE_START);
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