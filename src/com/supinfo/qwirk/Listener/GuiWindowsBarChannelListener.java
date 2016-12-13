package com.supinfo.qwirk.Listener;

import com.supinfo.qwirk.Frame.DialogChannelSceen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Boufle on 13/12/2016.
 */
public class GuiWindowsBarChannelListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        DialogChannelSceen.getInstance(Integer.parseInt(e.getComponent().getName()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
