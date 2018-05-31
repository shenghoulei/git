package cn.ssjt.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		while (true) {
			Socket socket = ss.accept();
			new Thread(new MyRunable(socket)).start();
		}
	}
}

class MyRunable implements Runnable {

	private Socket socket;

	public MyRunable(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			byte[] data = new byte[20];
			in.read(data);
			System.out.println(new String(data));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}