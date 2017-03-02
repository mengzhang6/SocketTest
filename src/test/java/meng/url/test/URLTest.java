package meng.url.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class URLTest {

	@Test
	public void urlTest() throws MalformedURLException {
		// 创建一个URL实例
		URL imooc = new URL("https://www.imooc.com:80");
		// ?后面表示参数，#后面表示锚点
		URL url = new URL(imooc, "/index.html?username=tom#test");
		System.out.println("协议：" + url.getProtocol());
		System.out.println("主机：" + url.getHost());
		// 如果未指定端口号，则使用默认的端口号，此时getPort()方法返回值为-1
		System.out.println("端口：" + url.getPort());
		System.out.println("文件路径：" + url.getPath());
		System.out.println("文件名：" + url.getFile());
		System.out.println("相对路径：" + url.getRef());
		System.out.println("查询字符串：" + url.getQuery());
	}

	@Test
	public void urlTest2() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			// 创建一个URL实例
			URL url = new URL("https://www.baidu.com");
			// 通过URL的openStream方法获取URL对象所表示的资源的字节输入流
			is = url.openStream();
			// 将字节输入流转换为字符输入流
			isr = new InputStreamReader(is, "utf-8");
			// 为字符输入流添加缓冲
			br = new BufferedReader(isr);
			String data = br.readLine();// 读取数据
			while (data != null) {// 循环读取数据
				System.out.println(data);// 输出数据
				data = br.readLine();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
