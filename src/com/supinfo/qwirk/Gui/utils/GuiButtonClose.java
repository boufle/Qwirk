package com.supinfo.qwirk.Gui.utils;

import com.supinfo.qwirk.Listener.GuiCloseButtonListener;

import javax.swing.*;

/**
 * Created by Boufle on 13/12/2016.
 */
public class GuiButtonClose extends JButton {

    public GuiButtonClose(){

        addActionListener(new GuiCloseButtonListener());
    }
}
