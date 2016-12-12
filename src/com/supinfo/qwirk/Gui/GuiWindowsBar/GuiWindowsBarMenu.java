package com.supinfo.qwirk.Gui.GuiWindowsBar;

import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiMenuButton.GuiWindowsBarMenuFeedButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiWindowsBarMenu extends JPanel{

    protected GuiWindowsBarMenuFeedButton guiWindowsBarMenuFeedButton = new GuiWindowsBarMenuFeedButton();

    public GuiWindowsBarMenu(){

        setBackground(new Color(38,51,67));
        setLayout(new GridLayout(5,1));

        add(guiWindowsBarMenuFeedButton);

    }
}
