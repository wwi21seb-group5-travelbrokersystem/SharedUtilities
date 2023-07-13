package org.wwi21seb.vs.group5.TwoPhaseCommit;

import java.io.Serial;
import java.io.Serializable;
import java.net.InetAddress;

public class Coordinator implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private InetAddress url;
    private int port;

    private Coordinator() {

    }

    public Coordinator(String name, InetAddress url, int port) {
        this.name = name;
        this.url = url;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public InetAddress getUrl() {
        return url;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "Coordinator{" + "name=" + name + ", url=" + url + ", port=" + port + '}';
    }

}
