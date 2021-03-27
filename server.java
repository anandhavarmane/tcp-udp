import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class server {
    public static void main(String[] a)throws Exception{
        Scanner scn =new Scanner(System.in);
        DatagramSocket ds=new DatagramSocket(9999);
        InetAddress io=InetAddress.getLocalHost();
        String str;
        while(true)
        {
            byte[] b1= new byte[1024];
            DatagramPacket dp1=new DatagramPacket(b1,b1.length);
            ds.receive(dp1);
            String str1=new String(dp1.getData(),0,dp1.getLength());
            System.out.println("Message : "+str1);
            if(str1.equals("bye"))
            {
                System.out.println("Exit.....");
                break;
            }
            System.out.println("Enter the message (bye to exit):");
            str=scn.nextLine();
            byte[] b=str.getBytes();
            DatagramPacket dp=new DatagramPacket(b,b.length,io,dp1.getPort());
            ds.send(dp);
            if(str.equals("bye"))
            {
                System.out.println("Exit.....");
                break;
            }
        }
        scn.close();
        ds.close();
    }
}
