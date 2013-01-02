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
    
    /**
     * Host to send packet to
     * @param address
     * @return true if host exists
     */
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
    
    /**
     * Type of data to send
     * Example:   Payload.MAX_PLAYERS
     * @param p 
     */
    public void setPayload(Payload p){
        this.payload=p;
    }
    
    /**
     * Data related to the payload.
     * Example: If payload if MAX_PLAYERS then this
     * should be the max number of players the
     * server will allow on
     * @param data Data to be sent
     */
    public void setData(String data){
        this.data=data;
    }
    
    /**
     * Data related to the payload.
     * Example: If payload if MAX_PLAYERS then this
     * should be the max number of players the
     * server will allow on
     * @return Data the packet contained
     */
    public String getData(){
        return this.data;
    }
    
    /**
     * Get the type of data the packet contains
     * @return 
     */
    public Payload getPayload(){
        return this.payload;
    }
    
    /**
     * Who is this packet going to?
     * @return Host to receive packet
     */
    public InetAddress getTargetHost(){
        return this.targetHost;
    }
    
    /**
     * Port to use
     * @return 
     */
    public int getTargetPort(){
        return this.Port;
    }
    
    /**
     * Use this to convert the packet into something
     * you can send with UDP.
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder strFac = new StringBuilder();
        strFac.append(payload.toString());
        strFac.append(this.SPLIT);
        strFac.append(getData());
        return strFac.toString();
    }
}
