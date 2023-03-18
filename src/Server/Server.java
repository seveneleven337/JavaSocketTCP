package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Server extends Observable implements Runnable {

	private int port;
	
	public Server(int port) {
		this.port = port;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		ServerSocket server = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		
		try {
			server = new ServerSocket(port);
			System.out.println("server running");
			
			while(true) {
				sc = server.accept();        // listening client socket
				System.out.println("Client connected");
				in = new DataInputStream(sc.getInputStream());
				//out = new DataOutputStream(sc.getOutputStream());
				
				
				String message = in.readUTF(); 		//wait until client send info
				System.out.println(message);
				//out.writeUTF("message received in the server");
				
				this.setChanged();
				this.notifyObservers(message);
				this.clearChanged();
				
				sc.close();
				System.out.println("Client disconnected");
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
