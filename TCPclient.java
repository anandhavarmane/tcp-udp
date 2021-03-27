import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPclient {
     public static void main(String[] args)throws Exception {
        String st="localhost";
        int port=8000;
        Scanner scan=new Scanner(System.in);
        String s1="hello",s2="hello";
        Socket s=new Socket(st,port);
        DataOutputStream d=new DataOutputStream(s.getOutputStream());
        DataInputStream d1=new DataInputStream(s.getInputStream());
        while(true)
        {
        System.out.println("Enter the message(bye to close the chat): ");
        s1=scan.nextLine();
        d.writeUTF(s1);
        d.flush();
        if(s1.equals("bye"))
        {
            System.out.println("chat closed!!");
            break;
        }
        s2=(String)d1.readUTF();
        System.out.println("Reply : "+s2);
        if(s2.equals("bye"))
        {
            System.out.println("chat closed!!");
            break;
        }
        }
        s.close();
        scan.close();
    }
}
