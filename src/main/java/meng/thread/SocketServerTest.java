package meng.thread;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			// 创建服务器socket
			ServerSocket server = new ServerSocket(60001);
			System.out.println("服务器已启动，等待连接······");
			Socket client = null;
			int count = 0;

			// 循环监听，等待客户端的连接
			while (true) {
				// 等待客户端连接
				client = server.accept();
				System.out.print("有一个客户端连接，");
				count++;
				System.out.println("此客户端IP："
						+ client.getInetAddress().getHostAddress());
				System.out.println("客户端数量：" + count);

				ServerThread serverThread = new ServerThread(client);
				serverThread.start();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
