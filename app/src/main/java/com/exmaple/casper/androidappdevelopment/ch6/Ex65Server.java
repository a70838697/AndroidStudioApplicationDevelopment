package com.exmaple.casper.androidappdevelopment.ch6;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Ex65Server
{
    private ServerSocket ss;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    public Ex65Server()
    {
        new ServerThread().start();
    }
    class ServerThread extends Thread
    {
        public void run()
        {
            try {
                ss=new ServerSocket(4321);
                out.println("服务器启动了");
                while(true)
                {
                    socket = ss.accept();
                    out.println("有客户端连接到服务器");
                    dis = new DataInputStream(socket.getInputStream());
                    dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF("恭喜你，连接服务器成功！ \n");
                    dos.flush();
                    out.println("服务器休眠20秒......");
                    Thread.sleep(500);
                    String msg="";
                    if((msg = dis.readUTF()) != null) {
                        out.println(msg);
                    }
                    dos.writeUTF("你发来的数据服务器收到了。^_^");
                    dos.flush();
                }
            }
            catch (Exception e) {
                out.println("读写错误");}
            finally{
                try {
                    System.in.close();
                    out.close();
                } catch (IOException e) {e.printStackTrace();}
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        new Ex65Server();
    }
}

