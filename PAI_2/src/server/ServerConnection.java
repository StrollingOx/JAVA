package server;

import java.net.*;
import java.io.*;

public class ServerConnection extends Thread
{
    private Socket socket;
    private Server server;
    private DataInputStream din;
    private DataOutputStream dout;
    private boolean online = true;

    public ServerConnection(Socket clientSocket, Server server)
    {
        super("ServerConnectionThread");
        this.socket = clientSocket;
        this.server = server;
    }

    public void sendStringToClient(String message)
    {
        try
        {
            dout.writeUTF(message);
            dout.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void sendStringToAllClients(String message)
    {
        for (int i = 0; i < server.connections.size(); i++)
        {
            ServerConnection serverConnection = server.connections.get(i);
            serverConnection.sendStringToClient("SERVER>>"+message);
        }
    }
    public void run()
    {
        try
        {
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            while(online)
            {
                while(din.available() == 0)
                {
                    try
                    {
                        Thread.sleep(1);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                String receiverMessage = din.readUTF();
                sendStringToAllClients(receiverMessage);
            }
            din.close();
            dout.close();
            socket.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
