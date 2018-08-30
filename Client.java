import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{

	private Socket socket;
	private String nick;
	private String userName;
	private String realName;
	static PrintWriter out;
	static Scanner in;
	
	public Client(Socket s,String nick,String userName,String realName){
		
		socket = s;
		this.nick = nick;
		this.userName = userName;
		this.realName = realName;
		
	}
	@Override
	public void run() {
		
		try{
	
		out = new PrintWriter(socket.getOutputStream(),true);
		in = new Scanner(socket.getInputStream());
		
		write("NICK ", nick);
		write("USER ",userName+" 0 * :"+realName);
		write("JOIN","#freenode");
		
		
		while(in.hasNext()){
			String serverMessage = in.nextLine();
			System.out.println("<<< "+serverMessage);
		}
		
		in.close();
		out.close();
		socket.close();
		
		System.out.println("Done");
		
		}catch(Exception e){
			e.printStackTrace();
		}}
		
//		Scanner s = new Scanner(System.in);
//		String msg = s.nextLine();
//		System.out.println("Client said: "+msg);
		private static void write(String command,String message){
			String fulMessage = command+" "+message;
			System.out.println(">>> "+fulMessage);
			out.print(fulMessage+"\r\n");
			out.flush();
			
		}
	
	

}
