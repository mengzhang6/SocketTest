package meng.udp.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClientTest {

	public static void main(String[] args) {
		try {
			/**
			 * 向服务器端发送数据
			 */
			InetAddress inetAddress = InetAddress.getByName("localhost");
			int port = 60002;
			String data = "Hello World";
			byte[] bytes = data.getBytes();
			// 创建数据报
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
					inetAddress, port);
			// 发送数据报
			DatagramSocket client = new DatagramSocket();
			client.send(packet);

			/**
			 * 接收服务器端的响应
			 */
			// 创建数据报，用于接收响应
			byte[] bytes2 = new byte[1024];
			DatagramPacket packet2 = new DatagramPacket(bytes2, bytes2.length);
			// 接收响应
			client.receive(packet2);
			// 读取数据
			String respose = new String(bytes2, 0, packet2.getLength());
			System.out.println("服务器端的响应：" + respose);
			// 关闭资源
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
