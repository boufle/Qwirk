package com.supinfo.qwirk.Frame;

import com.supinfo.qwirk.Gui.GuiChat;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBar;
import com.supinfo.qwirk.Gui.utils.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class DialogHomeScreen extends JFrame {

    protected GuiWindowsBar guiWindowsBar = new GuiWindowsBar();
    protected GuiChat guiChat = new GuiChat();

    private DialogHomeScreen(){
        setUndecorated(true);
        setSize(1400,800);
        setLocation(utils.getInstance().getPosX(), utils.getInstance().getPosY());
/*        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
            }
        });*/
        setLayout(new BorderLayout());
        init();
        setVisible(true);
    }

    public void init(){

        add(guiChat, BorderLayout.LINE_END);
        add(guiWindowsBar, BorderLayout.LINE_START);

    }

    private static DialogHomeScreen INSTANCE = null;

    public static synchronized DialogHomeScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DialogHomeScreen();
        }
        return INSTANCE;
    }

    public GuiWindowsBar getGuiWindowsBar() {
        return guiWindowsBar;
    }
}
