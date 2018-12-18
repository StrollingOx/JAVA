package server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server
{
    private static final int PORT_NUMBER = 4999;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream din;
    private DataOutputStream dout;
    private boolean online = true;
    public ArrayList<ServerConnection> connections = new ArrayList<ServerConnection>();

    public static void main(String[] args) throws IOException
    {
        new Server();
    }

    public Server ()
    {
        System.out.printf("SERVER IS ONLINE\n");
        try
        {
            serverSocket = new ServerSocket(PORT_NUMBER);
            while(online)
            {
                clientSocket = serverSocket.accept();
                System.out.printf("Client connected\n");

                ServerConnection serverConnection = new ServerConnection(clientSocket, this);
                serverConnection.start();
                connections.add(serverConnection);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
