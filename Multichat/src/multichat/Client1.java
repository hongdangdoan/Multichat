package multichat;

import java.net.*;
import java.util.Scanner;



public class Client1 {
	
	
	
	public static void main(String[]args) throws Exception {
		InetAddress IPAddress = InetAddress.getByName("localhost");
		int port = 101;
		DatagramSocket clientSocket = new DatagramSocket(1111);
		byte[] receiveData;
		byte[] sendData;
		DatagramPacket receivePacket;
		DatagramPacket sendPacket;
		System.out.println("Client 1");
		while(true) {
			int choise = 1;
			Scanner scanner = new Scanner(System.in);
			while(true) {
				System.out.println("1. nhan tin nhan");
				System.out.println("2. gui tin nhan");
				choise = scanner.nextInt();
				scanner.nextLine();
				if(choise ==1) {
					//nhan tin nhan;
					receiveData = new byte[1024];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
				    String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
				   // System.out.print("loi nhan tu "+ sender +", "+ port+ " nguoi nhan: "+ receiver+ " " );
					System.out.println("loi nhan tu Client2, noi dung "+ message); 
				}
				if(choise ==2) {
					String message;
				    
						//lay ten nguoi gui
					sendData = new byte[1024];
					sendData = "Client1".getBytes();
					sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
					clientSocket.send(sendPacket);
						//lay ten nguoi nhan
					System.out.println("nhap ten nguoi nhan: ");
					message = scanner.nextLine();
					
					sendData = new byte[1024];
					sendData = message.getBytes();
					sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
					clientSocket.send(sendPacket);
						//gui
					System.out.println("nhap tin nhan: ");
					message = scanner.nextLine();
					sendData = new byte[1024];
					sendData = message.getBytes();
					sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
					clientSocket.send(sendPacket); 
						
				}
				
			}
			
		}
	}
}
