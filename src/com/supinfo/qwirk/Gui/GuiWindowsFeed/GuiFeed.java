package com.supinfo.qwirk.Gui.GuiWindowsFeed;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiFeed extends JPanel {

    protected GuiFeedsBanner guiFeedsBanner;
    protected JLabel title ;

    public GuiFeed(String urlBanner, String title){
        guiFeedsBanner = new GuiFeedsBanner(urlBanner);
        this.title = new JLabel(title,SwingConstants.CENTER);
        setBackground(new Color(69, 93, 113));
        setLayout(new BorderLayout());
        add(guiFeedsBanner, BorderLayout.PAGE_START);
        add(this.title, BorderLayout.CENTER);
        add(new GuiFeedJoinButton(), BorderLayout.PAGE_END);

    }


}
