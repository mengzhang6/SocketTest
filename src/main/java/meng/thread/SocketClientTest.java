package meng.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest {

	public static void main(String[] args) {
		try {

			// 1.连接服务器
			Socket socket = new Socket("127.0.0.1", 60001);
			// 2.获取输出流
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter pWriter = new PrintWriter(outputStream);
			pWriter.write("hello");
			pWriter.flush();
			socket.shutdownOutput();

			// 获取输入流
			InputStream inputStream = socket.getInputStream();// 字节输入流
			InputStreamReader isReader = new InputStreamReader(inputStream);// 转化为字符输入流
			BufferedReader bReader = new BufferedReader(isReader);// 为输入流添加缓冲
			//
			String data = null;// 读取数据
			while ((data = bReader.readLine()) != null) {// 循环读取数据
				System.out.println("服务器端响应：" + data);// 输出数据
			}
			// 关闭输入流
			socket.shutdownInput();

			// 3.关闭
			bReader.close();
			isReader.close();
			inputStream.close();

			pWriter.close();
			outputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
