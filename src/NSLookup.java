import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class NSLookup {
	
	public static void main(String[] args) {
		
		InetAddress inetaddr[] = null;
		
		try {
			inetaddr = InetAddress.getAllByName(
						JOptionPane.showInputDialog("도메인을 입력하시오.")
						);
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < inetaddr.length; i++) {
			System.out.println(inetaddr[i].getHostName()); //도메인 이름
			System.out.println(inetaddr[i].getHostAddress()); //도메인 주소
			System.out.println(inetaddr[i].toString()); //도메인 이름 + 주소
			System.out.println("---------------------------");
		}
		
	}
}