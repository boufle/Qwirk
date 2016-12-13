package com.supinfo.qwirk.Gui.utils;

/**
 * Created by Boufle on 13/12/2016.
 */
public class utils {

    int posY = 0;
    int posX = 0;
    private static utils ourInstance = new utils();

    public static utils getInstance() {
        return ourInstance;
    }

    private utils() {
    }

    public int getPosY(){
        return posY;
    }
    public int getPosX(){
        return posX;
    }
    public void setPosY(int posY){
        this.posY = posY;
    }
    public void setPosX(int posX){
        this.posX = posX;
    }
}
