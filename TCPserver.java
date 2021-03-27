import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPserver {
     public static void main(String[] args)throws Exception {
        ServerSocket ss=new ServerSocket(8000);
        Socket s=ss.accept();
        System.out.println("System is online now....");
        Scanner scan=new Scanner(System.in);
        String s1="hello",s2="hello";
        DataInputStream di=new DataInputStream(s.getInputStream());
        DataOutputStream d=new DataOutputStream(s.getOutputStream());
        while(true)
        {
        s1=(String)di.readUTF();
        System.out.println("Reply : "+s1);
        if(s1.equals("bye"))
        {
            System.out.println("chat closed!!");
            break;
        }
        System.out.println("Enter the message(bye to close the chat): ");
        s2=scan.nextLine();
        d.writeUTF(s2);
        d.flush();
        if(s2.equals("bye"))
        {
            System.out.println("chat closed!!");
            break;
        }
        }
        ss.close();
        scan.close();
     }
}
