package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable{
	
	private int port;
	private String message;
	
	public Client(int port, String message) {
		this.port = port;
		this.message = message;
	}


	@Override
	public void run() {
		
		//DataInputStream in;
		DataOutputStream out;
		
		try {
			
			/*final DatagramSocket socket = new DatagramSocket();
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			String host = socket.getLocalAddress().getHostAddress();
			System.out.println(host);*/
					
			String host = "127.0.0.1";
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
