import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class client {
    //connectionless protocol 
    //so every pocket need to know where it goes
     public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);
        String str;
        DatagramSocket ds=new DatagramSocket();
        // data , data length, ip address , port number
        //byte array format
        // to convert byte array first need to convert the int to string by i+" " then get
        // bytes method is to convert string into bytes.
        InetAddress io= InetAddress.getLocalHost();
        while(true)
        {
            System.out.println("Enter the message (bye to exit):");
            str=scan.nextLine();
            byte[] b=str.getBytes();
            DatagramPacket dp=new DatagramPacket(b,b.length,io,9999);
            ds.send(dp);
            if(str.equals("bye"))
            {
                System.out.println("Exit.....");
                break;
            }
            byte[] b1= new byte[1024];
            DatagramPacket dp1=new DatagramPacket(b1,b1.length);
            ds.receive(dp1);
            String str1=new String(dp1.getData(),0,dp1.getLength());
            System.out.println("Reply : "+str1);
            if(str1.equals("bye"))
            {
                System.out.println("Exit.....");
                break;
            }
        }
        scan.close();
        ds.close();
    }
}
