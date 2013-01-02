package me.daneuz23;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.mgenterprises.bukkit.Payload;
import org.mgenterprises.bukkit.ServerStatusPacket;
/**
 *
 * @author Home
 */
public class NServerStatusSR extends JavaPlugin implements Listener {

    public void onEnable() {
        getLogger().info("onEnable has been invoked!");

    }

    public void onDisable() {
        getLogger().info("onDisable has been invoked!");

    }

    public void sendUDPPacket(ServerStatusPacket ssp) {
        try {  
            //GOOD
            int port = ssp.getTargetPort();
            //This isn't needed since you specified the host below
            InetAddress.getByName("192.168.1.26");
            ssp.setTargetPort(1337);
            //You set the type but never set the data
            //You are saying "I have NULL max players"  use this.getServer().getMaxPlayers();
            ssp.setPayload(Payload.PLAYER_MAX); 
            //unneeded
            ssp.getTargetPort();
            //unneeded
            ssp.getPayload();
            //unneeded
            ssp.toString();
            //GOOD
            byte[] message = ssp.toString().getBytes();
            
            //GOOD
            InetAddress address = ssp.getTargetHost();

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
