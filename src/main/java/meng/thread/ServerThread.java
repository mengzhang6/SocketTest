package meng.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

	Socket client = null;

	public ServerThread(Socket socket) {
		this.client = socket;
	}

	@Override
	public void run() {
		InputStream inputStream = null;
		InputStreamReader isReader = null;
		BufferedReader bReader = null;
		OutputStream outputStream = null;
		PrintWriter pWriter = null;
		try {
			// 获取输入流
			inputStream = client.getInputStream();// 字节输入流
			isReader = new InputStreamReader(inputStream);// 转化为字符输入流
			bReader = new BufferedReader(isReader);// 为输入流添加缓冲
			//
			String data = null;// 读取数据
			while ((data = bReader.readLine()) != null) {// 循环读取数据
				System.out.println("客户端说：" + data);// 输出数据
			}
			// 关闭输入流
			client.shutdownInput();

			// 获取输出流
			outputStream = client.getOutputStream();
			pWriter = new PrintWriter(outputStream);
			pWriter.write("我是服务端，有事请留言。");
			pWriter.flush();
			client.shutdownOutput();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
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

}
