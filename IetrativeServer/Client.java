// A Java program for a Client 
import java.net.*; 
import java.io.*; 
import java.util.*;

public class Client 
{ 
	// initialize socket and input output streams 
	private Socket socket		 = null; 
	private DataInputStream input = null; 
	private DataOutputStream out	 = null; 

	// constructor to put ip address and port 
	public Client(String address, int port) 
	{ 
		// establish a connection 
		Scanner sc=new Scanner(System.in);
		try
		{ 
			socket = new Socket(address, port); 
			System.out.println("Connected"); 
			//Scanner sc=new Scanner(System.in);

			// takes input from terminal 
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 

			// sends output to the socket 
			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
		int line =0; 
		String send_line = "";
		while (line!=-1) 
		{ 
			try
			{ 
				System.out.println("Enter the data");
				line = sc.nextInt();
				out.writeInt(line);
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
		}
		try{
		send_line=input.readUTF();
		System.out.println(send_line);
		}
		catch(IOException e){
		System.out.println(e);
}
		try
		{ 
			input.close(); 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Client client = new Client("your server ip", write port ); 
	} 
} 
