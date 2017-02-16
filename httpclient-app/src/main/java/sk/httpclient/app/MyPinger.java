package sk.httpclient.app;

import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;

public class MyPinger extends PingUrl {

    @Override
    public boolean isAlive(Server server) {
        System.out.println("Going to ping server " + server.getPort());

        boolean alive = false;
        try {
            alive = super.isAlive(server);
        } catch (Throwable e) {
            return false;
        }
        System.out.println("Ping server " + server.getPort() + "; alive=" + alive);
        return alive;
    }
}
