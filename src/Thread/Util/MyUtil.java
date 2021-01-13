package Thread.Util;

import java.io.Closeable;

public class MyUtil {

	public static void closeAll (Closeable...close) {
		for (Closeable temp : close) {
			try {
				temp.close();
			} catch (Exception e) {
				
			}
		}
	}
}
