package com.supinfo.qwirk.Gui.GuiFrameControlBar;

import com.supinfo.qwirk.Gui.utils.GuiButtonClose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Boufle on 13/12/2016.
 */
public class GuiFrameCrontrolBar extends JPanel {

    protected GuiButtonClose guiButtonClose = new GuiButtonClose();

    public GuiFrameCrontrolBar(){

        setPreferredSize(new Dimension(0,69));
        setBackground(new Color(38,51,67));
        setLayout(new BorderLayout());
        add(guiButtonClose, BorderLayout.LINE_END);
    }

}
