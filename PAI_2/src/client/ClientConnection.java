package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnection extends Thread
{
    private Socket socket;
    private DataInputStream din;
    private DataOutputStream dout;
    private boolean online = true;

    public ClientConnection(Socket socket, Client client)
    {
        this.socket = socket;
    }

    public void sendStringToServer(String clientMessage)
    {
        try {
            dout.writeUTF(clientMessage);
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
            close();
        }
    }

    public void run()
    {
        try
        {
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        while (online)
        {
            try
            {
                while (din.available() == 0)
                {
                    Thread.sleep(1);
                }
                String serverReply = din.readUTF();
                System.out.println(serverReply);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void close()
    {
        try {
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
