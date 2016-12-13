package com.supinfo.qwirk.Gui.GuiWindowsBar;

import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiMenuButton.GuiWindowsBarMenuFeedButton;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiMenuButton.GuiWindowsBarMenuHomeButton;
import com.supinfo.qwirk.Listener.GuiWindowsBarMenuListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiWindowsBarMenu extends JPanel{

    protected GuiWindowsBarMenuFeedButton guiWindowsBarMenuFeedButton = new GuiWindowsBarMenuFeedButton();
    protected GuiWindowsBarMenuHomeButton guiWindowsBarMenuHomeButton = new GuiWindowsBarMenuHomeButton();
    protected JPanel add = new JPanel();
    protected JLabel ici = new JLabel("<html><body>Vos <br> Channels</body></html>");


    public GuiWindowsBarMenu(){

        setBackground(new Color(38,51,67));
        setLayout(new GridLayout(5,1));

        add(guiWindowsBarMenuFeedButton);
        add(guiWindowsBarMenuHomeButton);
        add.addMouseListener(new GuiWindowsBarMenuListener());
        add(add);
        ici.setForeground(Color.WHITE);
        add(ici);



    }


    public void setSelectedFeed(){
        guiWindowsBarMenuFeedButton.setBackground(new Color(61,83,100));
        guiWindowsBarMenuHomeButton.setBackground(new Color(38,51,67));
    }

    public void setSelectedHome(){
        guiWindowsBarMenuHomeButton.setBackground(new Color(61,83,100));
        guiWindowsBarMenuFeedButton.setBackground(new Color(38,51,67));
    }
}
