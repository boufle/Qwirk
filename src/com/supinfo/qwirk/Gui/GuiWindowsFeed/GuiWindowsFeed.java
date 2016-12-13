package com.supinfo.qwirk.Gui.GuiWindowsFeed;

import com.supinfo.qwirk.Gui.GuiFrameControlBar.GuiFrameCrontrolBar;
import com.supinfo.qwirk.Gui.utils.GuiButton;
import com.supinfo.qwirk.Gui.utils.utils;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiWindowsFeed extends JPanel {

    JPanel bot = new JPanel();
    protected JPanel body = new JPanel();
    protected JPanel pagination = new JPanel();
    protected GuiFrameCrontrolBar top = new GuiFrameCrontrolBar();
    protected GuiButton leftarrow = new GuiButton();
    protected GuiButton rightarrow = new GuiButton();
    int posX ;
    int posY ;


    public GuiWindowsFeed(){
      //  this.getParent();

        setLayout(new BorderLayout());
        prepareFeed(body);
        add(body, BorderLayout.CENTER);
        bot.setPreferredSize(new Dimension(0,69));
        bot.setBackground(new Color(38,51,67));
        bot.setLayout(new BorderLayout());
        pagination.setLayout(new BorderLayout());
        pagination.setPreferredSize(new Dimension(150,40));
        pagination.setBackground(new Color(38,51,67));
        //pagination.add(leftarrow, BorderLayout.LINE_START);
      //  pagination.add(rightarrow, BorderLayout.LINE_END);
        bot.add(pagination, BorderLayout.LINE_END);
       // add(bot, BorderLayout.PAGE_END);
        add(top, BorderLayout.PAGE_START);

        top.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                posX = e.getX();
                posY = e.getY();
            }
        });

        top.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                int depX = e.getX() - posX;
                int depY = e.getY() - posY;
                //JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(e.getComponent());
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(e.getComponent());

                topFrame.setLocation(topFrame.getX() + depX, topFrame.getY() + depY);
                utils.getInstance().setPosX(topFrame.getX() + depX);
                utils.getInstance().setPosY(topFrame.getY() + depY);
            }
        });


    }

    public void prepareFeed(JPanel body){

        body.setLayout(new GridLayout(0,3,5,5));
        for (int i = 0; i < 12; i++){

            GuiFeed guiFeed = new GuiFeed("https://image.jimcdn.com/app/cms/image/transf/dimension=360x10000:format=jpg/path/sb9ccc28c2a9d590e/image/ib4429f54ba79584a/version/1318533548/image.jpg", "test");
            body.add(guiFeed);
        }
    }
}
