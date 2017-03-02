package meng.inet.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.junit.Test;

public class InetAddressTest {

	@Test
	public void inetAddressTest() throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
		System.out.println(Arrays.toString(address.getAddress()));
	}

	@Test
	public void inetAddressTest2() throws UnknownHostException {
		InetAddress address2 = InetAddress.getByName("DESKTOP-PV63B6B");
		System.out.println(address2);
		System.out.println("------------");

		InetAddress address3 = InetAddress.getByName("192.168.1.100");
		System.out.println(address3.getHostName());
		System.out.println(address3.getHostAddress());

	}

	@Test
	public void inetAddressTest3() throws UnknownHostException {
		String ip = "192.168.1.100";
		InetAddress address3 = InetAddress.getByAddress(ip.getBytes());
		System.out.println(address3);
	}

}
