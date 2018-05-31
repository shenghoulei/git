package cn.ssjt.nio;

import java.nio.ByteBuffer;

public class Demo {
	public static void main(String[] args) {
		// 1. 创建指定大小的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(5);

		// 2. 写入数据
		buffer.put("a".getBytes());
		buffer.put("b".getBytes());
		buffer.put("c".getBytes());
		buffer.put("d".getBytes());
		buffer.put("e".getBytes());

		// 3. 打印数据
		buffer.rewind();
		byte[] data = new byte[1];
		buffer.get(data);
		String str = new String(data);
		System.out.println(str);
		
		buffer.mark();
		buffer.get(data);
		str = new String(data);
		System.out.println(str);
		
		buffer.reset();
		buffer.get(data);
		str = new String(data);
		System.out.println(str);
		
		

	}

}
