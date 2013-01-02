/*
 * DO NOT DISTRIBUTE. ©2012 MG ENTERPRISES(MANUEL GAUTO)
 */
package org.mgenterprises.bukkit;

/**
 *
 * @author Manuel Gauto
 */
public enum Payload {
    SERVER_RESETTING("SERVER_RESETTING"),
    PLAYER_COUNT("PLAYER_COUNT"),
    PLAYER_MAX("PLAYER_MAX");
    
    String stringName;
    private Payload(String stringName){
        this.stringName = stringName;
    }
    
    @Override
    public String toString(){
        return this.stringName;
    }
}
