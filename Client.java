import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{

	private Socket socket;
	public Client(Socket s){
		socket = s;
	}
	@Override
	public void run() {
		
		Scanner s = new Scanner(System.in);
		String msg = s.nextLine();
		System.out.println("Client said: "+msg);
	}
	
	

}
