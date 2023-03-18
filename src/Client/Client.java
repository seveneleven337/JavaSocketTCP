package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable{
	
	private String host = "127.0.0.1";
	private int port;
	private String message;
	
	public Client(String host, int port, String message) {
		this.host = host;
		this.port = port;
		this.message = message;
	}


	@Override
	public void run() {
		
		//DataInputStream in;
		DataOutputStream out;
		
		try {
					
			Socket sc = new Socket(host, port);
			//in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			out.writeUTF(message);
			
			sc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
