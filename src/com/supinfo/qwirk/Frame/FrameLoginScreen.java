package com.supinfo.qwirk.Frame;

import com.supinfo.qwirk.Database.ApplicationData;
import com.supinfo.qwirk.Database.UserDTO;
import com.supinfo.qwirk.Entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

/**
 * Created by Boufle on 12/12/2016.
 */
public class FrameLoginScreen extends JFrame implements ActionListener {

    protected JTextField login = new JTextField();
    protected JPasswordField mdp = new JPasswordField();
    protected JButton connect = new JButton();
    private ApplicationData applicationData;

    public FrameLoginScreen(ApplicationData applicationData){
        this.applicationData = applicationData;

        setUndecorated(true);
        setSize(400,600);
        setLayout(new GridLayout(10,1));
        add(login);
        add(mdp);
        add(connect);
        login.setText("theobeaudenon@yahoo.fr");
        mdp.setText("password");
        connect.setText("Valider");
        connect.addActionListener(this);
        //init();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            User user = UserDTO.login(applicationData,login.getText(), new String(mdp.getPassword()));
            if(user==null){
                System.out.println("user invalide");
            }else{
                //chargement des données de l'application
                final ImageIcon icon = new ImageIcon(new URL(user.getProfil_Icon()));
                JOptionPane.showMessageDialog(null, "Bonjour ".concat(user.getPseudo()) , "YES", JOptionPane.INFORMATION_MESSAGE, icon);


                applicationData.setCurrentUser(user);
                this.dispose();
                DialogFeedScreen.getInstance();
             }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
    }


}
