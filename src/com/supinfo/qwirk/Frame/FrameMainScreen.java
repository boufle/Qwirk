package com.supinfo.qwirk.Frame;

import com.supinfo.qwirk.Database.ApplicationData;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class FrameMainScreen extends JFrame{

    protected GuiWindowsBar guiWindowsBar = new GuiWindowsBar();

    public FrameMainScreen(ApplicationData applicationData){

        setUndecorated(true);
        setSize(1200,800);
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

        add(guiWindowsBar, BorderLayout.LINE_START);
    }
}
