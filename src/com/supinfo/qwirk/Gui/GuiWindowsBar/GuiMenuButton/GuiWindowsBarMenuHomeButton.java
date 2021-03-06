package com.supinfo.qwirk.Gui.GuiWindowsBar.GuiMenuButton;

import com.supinfo.qwirk.Listener.GuiWindowsBarMenuListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiWindowsBarMenuHomeButton extends JPanel {

    private BufferedImage image;
    public GuiWindowsBarMenuHomeButton(){

        setBackground(new Color(38,51,67));
        setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.CYAN));
        setPreferredSize(new Dimension(0,70));
        try {
            image = ImageIO.read(new File("img/home.png"));
        } catch (IOException ex) {
            // handle exception...
        }
        addMouseListener(new GuiWindowsBarMenuListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;
        g.drawImage(image, x, y, this); // see javadoc for more info on the parameters
    }
}
