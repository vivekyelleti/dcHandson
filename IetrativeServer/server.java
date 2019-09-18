//A Java Server Program 
import java.net.*; 
import java.io.*; 
import java.util.*;

public class server 
{ 
	//initialize socket and input stream 
	private Socket		 socket = null; 
	private ServerSocket server = null; 
	private DataInputStream in	 = null; 
	private DataOutputStream out =  null;

	public server(int port) 
	{ 
		try
		{ 
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			Scanner sc=new Scanner(System.in);

			System.out.println("Waiting for a client ..."); 

			socket = server.accept(); 
			System.out.println("Client accepted"); 
			in = new DataInputStream( 
				new BufferedInputStream(socket.getInputStream()));
			out = new DataOutputStream(socket.getOutputStream());

			int line = 0; 
			float sum=0;
			int count=0;
			while (line!=-1) 
			{ 
				try
				{ 
					System.out.println("data");
					line = in.readInt();
					System.out.println(line);
					sum+=line;
					count+=1;
				}
				catch(IOException i)
				{
					System.out.println(i); 
				} 
			}
				try{
				sum+=1;
				if((count-1)!=0){
				sum=sum/(count-1);
				out.writeUTF("MeaN"+sum);
				}
				else{
				out.writeUTF("MeaN"+0);
				}
				}
				catch(IOException i)
				{
					System.out.println(i);
				}
			System.out.println("Closing connection"); 
      
			socket.close(); 
			in.close();
      out.close();
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		server server = new server(write port ); 
	} 
} 
