package me.daneuz23;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
/**
 *
 * @author Aaron Neuzil
 */

public class ServerStatusSender extends JavaPlugin implements Listener {
        
    @Override
	public void onEnable(){
		getLogger().info("onEnable has been invoked!");
        
	}
        
        
 
    @Override
	public void onDisable(){
		getLogger().info("onDisable has been invoked!");
                         
	}
        
public class UDPReceive {
        
        public void main(String args[]) {
    
            try {
      int port = 1337;

      DatagramSocket dsocket = new DatagramSocket(port);

      byte[] buffer = new byte[2048];

      DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

      while (true) {
        
        dsocket.receive(packet);

        String msg = new String(buffer, 0, packet.getLength());
        System.out.println(packet.getAddress().getHostName() + ":"
            + msg);

        packet.setLength(buffer.length);
      }
    }catch (Exception e){
      System.err.println(e);
      
    }
  }         
}          
}
          
      

           
         
     