package com.hit.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class CacheUnitClient {
    public static final String LOCAL_HOST = "localhost";
    public static final Integer PORT = 12345;

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private InetAddress address;

    /**
     * Default constructor
     */
    public CacheUnitClient() {}


    /**
     * Send request from client to server
     * @param request - Json
     * @return response from the Server
     */
    public String send(String request) {
        String response = null;

        try {
            this.address = InetAddress.getByName(LOCAL_HOST);
            this.socket = new Socket(address, PORT);		//connect to server
            this.output = new DataOutputStream(socket.getOutputStream());//create stream for write the output
            this.input = new DataInputStream(socket.getInputStream());//create stream to read the input
            this.output.writeUTF(request);//write to server
            this.output.flush();

            response = (String) input.readUTF(); //the respond - read the server input


            socket.close();
            output.close();
            input.close();
            return response;	//return to CacheUnitClientObserver
        } catch(IOException e) {
            return "No connection to server";
        }
    }
}
