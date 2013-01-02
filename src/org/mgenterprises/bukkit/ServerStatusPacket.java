/*
 * DO NOT DISTRIBUTE. ©2012 MG ENTERPRISES(MANUEL GAUTO)
 */
package org.mgenterprises.bukkit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Gauto
 */
public class ServerStatusPacket{
    private Payload payload;
    private InetAddress targetHost;
    private int Port;
    private final String SPLIT="#!#";
    private String data;
    
    public ServerStatusPacket(Payload payload){
        this.payload=payload;
    }
    
    public ServerStatusPacket(String encodedPacketString){
        String[] parts = encodedPacketString.split(SPLIT);
        this.payload=Payload.valueOf(parts[0]);
        this.data=parts[1];
    }
    
    public boolean setTargetHost(String address){
        try {
            this.targetHost=InetAddress.getByName(address);
            return true;
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerStatusPacket.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void setTargetPort(int port){
        this.Port=port;
    }
    
    public void setPayload(Payload p){
        this.payload=p;
    }
    
    public void setData(String data){
        this.data=data;
    }
    
    public String getData(){
        return this.data;
    }
    
    public Payload getPayload(){
        return this.payload;
    }
    
    public InetAddress getTargetHost(){
        return this.targetHost;
    }
    
    public int getTargetPort(){
        return this.Port;
    }
    
    @Override
    public String toString(){
        StringBuilder strFac = new StringBuilder();
        strFac.append(payload.toString());
        strFac.append(this.SPLIT);
        strFac.append(getData());
        return strFac.toString();
    }
}
