package ThreadEx1;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("��� ��");
			while (true) {
				Socket sock = server.accept();
				EchoThread thread = new EchoThread(sock);
				thread.start();
			}
		} catch (Exception e) {}
	}
}
