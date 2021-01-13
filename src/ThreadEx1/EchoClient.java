package ThreadEx1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import Thread.Util.MyUtil;

public class EchoClient  {
	public static void main(String[] args) {
		Socket sock = null;
		
		OutputStream out = null;
		OutputStreamWriter osw = null;
		PrintWriter pw = null; 
		
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		BufferedReader keyboard = null;
		
		try {
			sock = new Socket("127.0.0.1" , 10001); 
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			out = sock.getOutputStream();
			osw = new OutputStreamWriter(out);
			pw = new PrintWriter(osw);
			
			in = sock.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);			
			
			String line = null;
			while ( (line = keyboard.readLine()) != null  ) { 
				if (line.equals("quit")) break;
				pw.println(line);
				pw.flush();
				String echo = br.readLine(); 
				System.out.println("서버로부터 전달받은 문자열 :" + echo);
			}
			
		} catch (IOException e) {
			
		} finally {
			MyUtil.closeAll(keyboard, br, isr, in, pw, osw , out , sock);
		}
 		
	}
}
