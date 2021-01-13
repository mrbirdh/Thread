package ThreadEx1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import Thread.Util.MyUtil;

public class EchoThread extends Thread{
	private Socket sock;
	
	public EchoThread (Socket sock) {
		this.sock = sock;
	}
	
	
	@Override 
	public void run () {
		OutputStream out = null;
		OutputStreamWriter osw = null;
		PrintWriter pw = null; 
		
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			InetAddress inetaddr = sock.getInetAddress(); 
			System.out.println(
					inetaddr.getHostAddress() + "로 부터 접속하였습니다."
			);
			
			out = sock.getOutputStream();
			osw = new OutputStreamWriter(out);
			pw = new PrintWriter(osw);
			
			in = sock.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);	
			
			String line = null;
			
			while ( (line = br.readLine()) != null ) {
				System.out.println(
						"클라이언트로 부터 전송받은 문자열 : " + line
				);
				pw.println(line);
				pw.flush();				
			}
			
		} catch (Exception e) {
			System.out.println("thread : " + e);
		} finally {
			MyUtil.closeAll(br, isr, in, pw, osw , out , sock);
		}
	}
}
