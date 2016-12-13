package com.supinfo.qwirk.Gui.GuiWindowsFeed;

import com.supinfo.qwirk.Gui.utils.GuiButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiWindowsFeed extends JPanel {

    JPanel bot = new JPanel();
    protected JPanel body = new JPanel();
    protected JPanel pagination = new JPanel();
    protected GuiButton leftarrow = new GuiButton();
    protected GuiButton rightarrow = new GuiButton();

    public GuiWindowsFeed(){

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
        add(bot, BorderLayout.PAGE_END);


    }

    public void prepareFeed(JPanel body){

        body.setLayout(new GridLayout(0,3,5,5));
        for (int i = 0; i < 12; i++){

            GuiFeed guiFeed = new GuiFeed("https://image.jimcdn.com/app/cms/image/transf/dimension=360x10000:format=jpg/path/sb9ccc28c2a9d590e/image/ib4429f54ba79584a/version/1318533548/image.jpg", "test");
            body.add(guiFeed);
        }
    }
}
