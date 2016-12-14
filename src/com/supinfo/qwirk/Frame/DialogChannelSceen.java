package com.supinfo.qwirk.Frame;

import com.supinfo.qwirk.Database.ApplicationData;
import com.supinfo.qwirk.Entity.Channel;
import com.supinfo.qwirk.Gui.GuiChat.GuiChat;
import com.supinfo.qwirk.Gui.GuiChat.GuiParticipant;
import com.supinfo.qwirk.Gui.GuiFrameControlBar.GuiFrameCrontrolBar;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBar;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBarChannel;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBarTool;
import com.supinfo.qwirk.Gui.utils.utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Boufle on 13/12/2016.
 */
public class DialogChannelSceen extends JFrame {

    protected GuiWindowsBar guiWindowsBar = new GuiWindowsBar();
    protected GuiChat guiChat;
    protected int chanID;
    protected JScrollPane jScrollPane ;
    protected GuiParticipant guiParticipant;
    protected GuiFrameCrontrolBar guiFrameCrontrolBar = new GuiFrameCrontrolBar();
    protected JPanel body = new JPanel();
    protected JPanel body2 = new JPanel();

    private DialogChannelSceen(int chanID){
        setUndecorated(true);
        setSize(1400,800);
        guiChat = new GuiChat(chanID);
        jScrollPane = new JScrollPane(guiChat);
        guiParticipant = new GuiParticipant(chanID);
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

        body2.setLayout(new BorderLayout());
        body2.add(guiChat,BorderLayout.CENTER);
        body2.add(new JTextField(), BorderLayout.PAGE_END);
        //jScrollPane.setPreferredSize(new Dimension(0,100));
        body.setLayout(new BorderLayout());
        body.add(body2, BorderLayout.CENTER);
        add(guiWindowsBar, BorderLayout.LINE_START);
        body.add(guiParticipant, BorderLayout.LINE_END);
        body.add(guiFrameCrontrolBar, BorderLayout.PAGE_START);
        add(body, BorderLayout.CENTER);

    }

    private static DialogChannelSceen INSTANCE = null;

    public static synchronized DialogChannelSceen getInstance(int chanID){
        if (INSTANCE == null){
            INSTANCE = new DialogChannelSceen(chanID);
        }
        else {
            INSTANCE.dispose();
            INSTANCE = new DialogChannelSceen(chanID);
        }
        return INSTANCE;
    }

    public GuiWindowsBar getGuiWindowsBar() {
        return guiWindowsBar;
    }
}
