package me.daneuz23;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.mgenterprises.bukkit.ServerStatusPacket;

/**
 *
 * @author Home
 */
public class NServerStatusSR extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("onEnable has been invoked!");

    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable has been invoked!");

    }

    public void sendUDPPacket(ServerStatusPacket ssp) {
        try {
            int port = ssp.getTargetPort();

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
