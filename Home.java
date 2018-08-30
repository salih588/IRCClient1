import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Home {

	private static String nick;
	private static String userName;
	private static String realName;
	private static String message;
	private static PrintWriter out;
	private static Scanner in;
	
	public static void main(String[] args){
		
		System.out.println("IRCClient ");
		
		Scanner s = new Scanner(System.in);
		
			try {
				System.out.print("Enter your nick name?");
				nick = s.nextLine();
				
				System.out.print("Enter user name?");
				userName = s.nextLine();
				
				System.out.print("enter your real name?");
				realName = s.nextLine();
				
				
				Socket socket = new Socket("chat.freenode.net",6667);
				
				Client client = new Client(socket,nick,userName,realName);
				
				Thread thread = new Thread(client);
				thread.start();
				
			
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	
}
