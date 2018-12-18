package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{
    private static final int PORT_NUMBER = 4999;
    private Socket client;
    private ClientConnection clientConnection;
    private Scanner cmd;

    public static void main(String[] args)
    {
        new Client();
    }

    public Client()
    {
        try
        {
            client = new Socket("localhost", PORT_NUMBER);
            clientConnection = new ClientConnection(client,this);
            clientConnection.start();


            listenForInput();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void listenForInput()
    {

        cmd = new Scanner(System.in);
        while(true)
        {
            while(!cmd.hasNextLine())
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
            String clientMessage = cmd.nextLine();
            if (clientMessage.toLowerCase().equals("quit")) {break;}

            clientConnection.sendStringToServer(clientMessage);
        }
        clientConnection.close();
    }
}
