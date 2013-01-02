package me.daneuz23;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.bukkit.plugin.java.JavaPlugin;
import org.mgenterprises.bukkit.Payload;
import org.mgenterprises.bukkit.ServerStatusPacket;
import org.mgenterprises.bukkit.event.Listener;

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
            int port = ssp.getTargetPort();
            InetAddress.getByName("192.168.1.26");
            ssp.setTargetPort(1337);
            ssp.setPayload(Payload.PLAYER_MAX);
            ssp.getTargetPort();
            ssp.getPayload();
            ssp.toString();
            byte[] message = ssp.toString().getBytes();

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
