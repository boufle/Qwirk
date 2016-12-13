package com.supinfo.qwirk.Gui;

import com.supinfo.qwirk.Database.ApplicationData;
import com.supinfo.qwirk.Entity.Channel;
import com.supinfo.qwirk.Entity.Message;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBarChannel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiChat extends JPanel {

    JTextArea jTextArea = new JTextArea();

    public GuiChat(int chanID){


        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(500,0));

        for (Message i: ApplicationData.getInstance().getData().getChannelByID(chanID).getMessages()){

            jTextArea.append(i.getTexte() + "  "+i.getDate() + "\n");
        }

        add(jTextArea);
    }
}
