package com.supinfo.qwirk.Gui.GuiWindowsFeed;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiFeedsBanner extends JPanel {


    private BufferedImage image;
    URL url;

    public GuiFeedsBanner(String urlBanner){

        setPreferredSize(new Dimension(0,50));

        try {
            url  = new URL(urlBanner);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            image = ImageIO.read(url);
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;
        g.drawImage(image, x, y, this); // see javadoc for more info on the parameters
    }
}
