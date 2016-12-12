package com.supinfo.qwirk.Entity;

import java.io.Serializable;
import java.sql.Blob;

/**
 * com.supinfo.qwirk.Entity
 * Created by Theo on 12/12/2016 for Qwirk.
 */
public class User implements Serializable{
    Integer id ;
    String pseudo;
    String email;
    String pass;
    String profil_Icon;
    Integer etat;

    public User(){};
    public User(Integer id, String pseudo, String email, String pass, String profil_Icon  ) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.pass = pass;
        this.profil_Icon = profil_Icon;
    }
    public User(Integer id, String pseudo, String email,   String profil_Icon  ) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.profil_Icon = profil_Icon;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getProfil_Icon() {
        return profil_Icon;
    }

    public void setProfil_Icon(String profil_Icon) {
        this.profil_Icon = profil_Icon;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }
}
