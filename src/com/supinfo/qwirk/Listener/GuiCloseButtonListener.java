package com.supinfo.qwirk.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Boufle on 13/12/2016.
 */
public class GuiCloseButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
