package cn.ssjt.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * NIO的serverSocketChannel和SocketChannel在默认情况下是阻塞模式
 * 
 * @author shy
 *
 */
public class SSDemo {
	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.bind(new InetSocketAddress(8888));
		SocketChannel sc = null;
		while (null==sc) {
			sc = ssc.accept();
		}
		
		ByteBuffer buf = ByteBuffer.allocate(5);
		sc.read(buf);
		 
		buf.rewind();
		byte[] data = new byte[1];
		while(buf.hasRemaining()) {
			buf.get(data);
			System.out.println(new String(data));
		}
	}
}
