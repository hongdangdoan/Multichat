package multichat;
import java.net.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;



public class Server {
	
	private List<Account> listAcc = new ArrayList<Account>() ;
	
	
	
public int findAcc(String str) {
	for(Account acc : listAcc) {
		if(acc.getName().equals(str))return acc.getPort();
	}
	return -1;
	}



public void makeListAcc(String name, int port) {
	listAcc.add(new Account(name, port));
}

	
	




	public static void main(String[]args) throws Exception {
		//tao danh sach nguoi dung
		Server server = new Server();
		server.makeListAcc("Client1", 1111);
		server.makeListAcc("Client2", 2222);
		DatagramSocket serverSocket = new DatagramSocket(101);
		byte[] receiveData;
		byte[] sendData;
		DatagramPacket receivePacket;
		DatagramPacket sendPacket;
		System.out.println("Multichat");
		while(true) {
			String sender;
			String receiver;
			String message;
			//lay ten nguoi gui
			receiveData = new byte[1024];
			receivePacket = new DatagramPacket(receiveData,receiveData.length);
			serverSocket.receive(receivePacket);
		    sender = new String(receivePacket.getData(), 0, receivePacket.getLength());
			//lay ten nguoi nhan
		    receivePacket = new DatagramPacket(receiveData,receiveData.length);
			serverSocket.receive(receivePacket);
		    receiver = new String(receivePacket.getData(), 0, receivePacket.getLength());
		    //lay tin nhan
		    receivePacket = new DatagramPacket(receiveData,receiveData.length);
			serverSocket.receive(receivePacket);
		    message = new String(receivePacket.getData(), 0, receivePacket.getLength());
		    //lay thong tin sender
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			System.out.print("loi nhan tu "+ sender +", "+ IPAddress+  port+ " nguoi nhan: "+ receiver+ " " );
			System.out.println("noi dung "+ message);
			//tim dia chi may nhan
			int rePort = server.findAcc(receiver);
			InetAddress IPr = InetAddress.getByName("localhost");
			sendData = message.getBytes();
			sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, rePort);
			serverSocket.send(sendPacket);
		}
	}

}
