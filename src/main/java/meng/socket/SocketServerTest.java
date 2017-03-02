package meng.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			// 1.创建服务器socket
			ServerSocket server = new ServerSocket(60001);
			System.out.println("服务器已启动，等待连接···");
			// 2.等待客户端连接
			Socket client = server.accept();
			System.out.print("有一个客户端连接，");
			// System.out.println(client.getInetAddress().getHostName());
			// System.out.println(client.getInetAddress().getHostAddress());
			// 3.获取输入流
			InputStream inputStream = client.getInputStream();// 字节输入流
			InputStreamReader isReader = new InputStreamReader(inputStream);// 转化为字符输入流
			BufferedReader bReader = new BufferedReader(isReader);// 为输入流添加缓冲
			//
			String data = null;// 读取数据
			while ((data = bReader.readLine()) != null) {// 循环读取数据
				System.out.println("客户端说：" + data);// 输出数据
			}
			// 关闭输入流
			client.shutdownInput();

			// 获取输出流
			OutputStream outputStream = client.getOutputStream();
			PrintWriter pWriter = new PrintWriter(outputStream);
			pWriter.write("i love you too.");
			pWriter.flush();
			client.shutdownOutput();// 关闭输出流
			// 4.关闭资源
			pWriter.close();
			outputStream.close();

			bReader.close();
			isReader.close();
			inputStream.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
