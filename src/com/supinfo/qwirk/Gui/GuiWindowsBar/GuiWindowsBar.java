package com.supinfo.qwirk.Gui.GuiWindowsBar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiWindowsBar extends JPanel {

    protected GuiWindowsBarTool guiWindowsBarTool = new GuiWindowsBarTool();
    protected GuiWindowsBarProfil guiWindowsBarProfil = new GuiWindowsBarProfil();
    protected GuiWindowsBarMenu guiWindowsBarMenu = new GuiWindowsBarMenu();

    public GuiWindowsBar (){

        setLayout(new BorderLayout());
        setBackground(new Color(38,51,67));
        setPreferredSize(new Dimension(100,0));
        init();
    }

    public void init(){
        add(guiWindowsBarTool, BorderLayout.PAGE_END);
        add(guiWindowsBarProfil, BorderLayout.PAGE_START);
        add(guiWindowsBarMenu, BorderLayout.CENTER);
    }


    public void setSelectedFeed(){
        guiWindowsBarMenu.setSelectedFeed();
    }

    public void setSelectedHome(){
        guiWindowsBarMenu.setSelectedHome();
    }
}
