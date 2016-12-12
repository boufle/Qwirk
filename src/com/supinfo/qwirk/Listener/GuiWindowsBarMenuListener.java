package com.supinfo.qwirk.Listener;

import com.supinfo.qwirk.Frame.DialogFeedScreen;
import com.supinfo.qwirk.Frame.DialogHomeScreen;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiMenuButton.GuiWindowsBarMenuFeedButton;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiMenuButton.GuiWindowsBarMenuHomeButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiWindowsBarMenuListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getComponent().getClass() == GuiWindowsBarMenuFeedButton.class){
            DialogFeedScreen.getInstance().getGuiWindowsBar().setSelectedFeed();
            DialogFeedScreen.getInstance().setVisible(true);
            DialogHomeScreen.getInstance().setVisible(false);
        }
        else if (e.getComponent().getClass() == GuiWindowsBarMenuHomeButton.class){
            DialogHomeScreen.getInstance().getGuiWindowsBar().setSelectedHome();
            DialogFeedScreen.getInstance().setVisible(false);
            DialogHomeScreen.getInstance().setVisible(true);
        }
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
