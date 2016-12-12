package com.supinfo.qwirk.Frame;

import com.supinfo.qwirk.Listener.ConnectionButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 12/12/2016.
 */
public class FrameLoginScreen extends JFrame {

    protected JTextField login = new JTextField();
    protected JTextField mdp = new JTextField();
    protected JButton connect = new JButton();

    public FrameLoginScreen(){

        setUndecorated(true);
        setSize(400,600);
        setLayout(new GridLayout(10,1));
        add(login);
        add(mdp);
        add(connect);
        login.setText("login");
        mdp.setText("mdp");
        connect.setText("Valider");
        connect.addActionListener(new ConnectionButtonListener());

        //init();

        setVisible(true);
    }



}
