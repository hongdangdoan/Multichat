package multichat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client2 {
	public static void main(String[]args) throws Exception {
		InetAddress IPAddress = InetAddress.getByName("localhost");
		int port = 101;
		DatagramSocket clientSocket = new DatagramSocket(2222);
		byte[] receiveData;
		byte[] sendData;
		DatagramPacket receivePacket;
		DatagramPacket sendPacket;
		System.out.println("Client 2" );
		while(true) {
			int choise = 1;
			Scanner scanner = new Scanner(System.in);
			String message;
			//nhan tin nhan;
			receiveData = new byte[1024];
			receivePacket = new DatagramPacket(receiveData,receiveData.length);
			clientSocket.receive(receivePacket);
		    message = new String(receivePacket.getData(), 0, receivePacket.getLength());
		    if(message ==null) {System.out.print("khong co tin nhan");}
		    //InetAddress IPAddress = receivePacket.getAddress();
		    else {
		int portS = receivePacket.getPort();
	    System.out.print("loi nhan tu Client1"+ ", "+ portS );
			System.out.println("noi dung "+ message);} 
			while(true) {
				System.out.println("0. thoat");
				System.out.println("2. gui tin nhan");
				choise = scanner.nextInt();
			    scanner.nextLine();
				if(choise ==0) {
					//nhan tin nhan;
//					receiveData = new byte[1024];
//					receivePacket = new DatagramPacket(receiveData,receiveData.length);
//					clientSocket.receive(receivePacket);
//				    message = new String(receivePacket.getData(), 0, receivePacket.getLength());
				   // System.out.print("loi nhan tu "+ sender +", "+ port+ " nguoi nhan: "+ receiver+ " " );
				//System.out.println("noi dung "+ message);
					break;
				}
				if(choise ==2) {
					
					scanner = new Scanner(System.in);
						//lay ten nguoi gui
					sendData = new byte[1024];
					sendData = "Client2".getBytes();
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
				
			
			
			scanner = new Scanner(System.in);
				//lay ten nguoi gui
			sendData = new byte[1024];
			sendData = "Client2".getBytes();
			sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			clientSocket.send(sendPacket);
				//lay ten nguoi nhan
			System.out.println("nhap ten nguoi nhan: ");
			message = scanner.nextLine();
			message.concat(String.valueOf("//"));message.concat("clien2");
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
			
			//nhan tin nhan;
			receiveData = new byte[1024];
			receivePacket = new DatagramPacket(receiveData,receiveData.length);
			clientSocket.receive(receivePacket);
		    message = new String(receivePacket.getData(), 0, receivePacket.getLength());
		   // System.out.print("loi nhan tu "+ sender +", "+ port+ " nguoi nhan: "+ receiver+ " " );
			System.out.println("noi dung "+ message);
		}
		}
	}

}
