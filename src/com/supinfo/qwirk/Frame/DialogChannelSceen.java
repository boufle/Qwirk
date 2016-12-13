package com.supinfo.qwirk.Frame;

import com.supinfo.qwirk.Gui.GuiChat;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBar;
import com.supinfo.qwirk.Gui.utils.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 13/12/2016.
 */
public class DialogChannelSceen extends JFrame {

    protected GuiWindowsBar guiWindowsBar = new GuiWindowsBar();
    protected GuiChat guiChat;
    protected int chanID;

    private DialogChannelSceen(int chanID){
        setUndecorated(true);
        setSize(1400,800);
        guiChat = new GuiChat(chanID);
        setLocation(utils.getInstance().getPosX(), utils.getInstance().getPosY());
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

        add(guiChat, BorderLayout.CENTER);
        add(guiWindowsBar, BorderLayout.LINE_START);

    }

    private static DialogChannelSceen INSTANCE = null;

    public static synchronized DialogChannelSceen getInstance(int chanID){
        if (INSTANCE == null){
            INSTANCE = new DialogChannelSceen(chanID);
        }
        else {
            INSTANCE = new DialogChannelSceen(chanID);
        }
        return INSTANCE;
    }

    public GuiWindowsBar getGuiWindowsBar() {
        return guiWindowsBar;
    }
}
