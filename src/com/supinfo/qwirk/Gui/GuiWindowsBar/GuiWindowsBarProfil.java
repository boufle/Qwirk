package com.supinfo.qwirk.Gui.GuiWindowsBar;

import com.supinfo.qwirk.Listener.GuiWindowsBarProfilListener;

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
public class GuiWindowsBarProfil extends JPanel {

    private BufferedImage image;
    URL url;

    public GuiWindowsBarProfil(){

        setBackground(new Color(38,51,67));
        setPreferredSize(new Dimension(0,70));
        try {
          url  = new URL("https://lh3.googleusercontent.com/-i-RclEmS5-8/AAAAAAAAAAI/AAAAAAAAAAA/AEMOYSBwrUXlYE616bpFhUEP5hWNoy2zfg/s32-c-mo/photo.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            image = ImageIO.read(url);
        } catch (IOException ex) {
            // handle exception...
        }
        addMouseListener(new GuiWindowsBarProfilListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;
        g.drawImage(image, x, y, this); // see javadoc for more info on the parameters
    }



}
