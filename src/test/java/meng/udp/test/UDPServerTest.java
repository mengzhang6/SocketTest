package meng.udp.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServerTest {

	public static void main(String[] args) {
		try {
			// 创建服务器端
			DatagramSocket socket = new DatagramSocket(60002);
			System.out.println("服务器端启动，等待连接······");
			// 创建数据报，用于接收客户端的数据
			byte[] bytes = new byte[1024];
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
			// 接收客户端的数据
			socket.receive(packet);// 此方法会阻塞进程
			// 读取客户端数据
			String result = new String(bytes, 0, packet.getLength());
			System.out.println("客户端说：" + result);

			/**
			 * 给客户端响应
			 */
			// 获取客户端信息
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			String rsponse = "Hello mengzhang6.";
			byte[] bytes2 = rsponse.getBytes();
			// 创建响应数据报
			DatagramPacket rsponsePacket = new DatagramPacket(bytes2,
					bytes2.length, address, port);
			// 发送
			socket.send(rsponsePacket);
			// 关闭资源
			socket.close();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
