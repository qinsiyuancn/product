package com.qinsiyuan.producter.maker.remote.server;

import java.io.IOException;
import java.net.Socket;

public class SocketServer extends Server{
    public SocketServer(Socket socket) throws IOException {
        super(socket.getInputStream(), socket.getOutputStream());
    }
    public static SocketServer getSocketServer(String url, int port) throws IOException {
        return new SocketServer(new Socket(url,port));
    }
}
