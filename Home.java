import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Home {

	public static void main(String[] args){
		
		System.out.println("IRCClient ");
		System.out.println("1.freenode");
		System.out.println("Select a number for connect freenode server");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		if( a==1){
			try {
				
				Socket socket = new Socket("chat.freenode.net",6667);
				System.out.println("client connected from "+socket.getLocalAddress().getHostName());
				Client chat = new Client(socket);
				Thread t = new Thread(chat);
				t.start();
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
