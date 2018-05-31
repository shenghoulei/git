package cn.ssjt.test;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 
 * @Description:
 * @author: shy
 * @time: 2018年5月30日 下午6:49:07
 */
public class Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		int i = 0;
		while (true) {
			Socket socket = new Socket();
			String str = "";
			socket.connect(new InetSocketAddress("127.0.0.1", 8888));
			OutputStream os = socket.getOutputStream();
			i++;
			str += i;
			os.write(str.getBytes());
			socket.close();
			Thread.sleep(500);
		}
	}
}
