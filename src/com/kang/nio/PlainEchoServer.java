package com.kang.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PlainEchoServer {

    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        //Bind server to port
        try {
            while (true) {
                // Block until new client connection is accepted final
                Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                //Create new thread to handle client connection
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                            //Read data from client and write it back
                            while (true) {
                                writer.println(reader.readLine());
                                writer.flush();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            try {
                                clientSocket.close();
                            } catch (IOException ex) {
                                // ignore on close
                            }
                        }
                    }
                }).start();
                //Start thread
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}