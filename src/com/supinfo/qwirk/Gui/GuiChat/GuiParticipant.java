package com.supinfo.qwirk.Gui.GuiChat;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 14/12/2016.
 */
public class GuiParticipant extends JPanel {

    public GuiParticipant(int chanID){

        
        setLayout(new GridLayout(20,1));
        setBackground(new Color(38,51,67));
        setPreferredSize(new Dimension(200,0));
    }
}
