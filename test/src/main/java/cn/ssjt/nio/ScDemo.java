package cn.ssjt.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ScDemo {
	public static void main(String[] args) throws Exception {
		SocketChannel sc = SocketChannel.open();
		sc.configureBlocking(false);
		boolean connect = sc.connect(new InetSocketAddress("127.0.0.1", 8888));
		System.out.println("ssjt");
		while (!connect) {
			connect = sc.finishConnect();
		}

		ByteBuffer buf = ByteBuffer.wrap("ssjt".getBytes());
		sc.write(buf);
	}

}
