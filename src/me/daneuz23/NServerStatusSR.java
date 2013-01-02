package me.daneuz23;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Home
 */
public class NServerStatusSR extends JavaPlugin implements Listener {
    

public class UDPSend {
        /**
         *
         * @param args
         */
public void main(String args[]) {
      try {
      String host;
        host = "192.168.1.26";
      int port = 1337;
 
      byte[] message = "Stopping".getBytes();
 
      InetAddress address = InetAddress.getByName(host);
 
       DatagramPacket packet = new DatagramPacket(message, message.length,
          address, port);
        try (DatagramSocket dsocket = new DatagramSocket()) {
            dsocket.send(packet);
        }
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
}    

    

