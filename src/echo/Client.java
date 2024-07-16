package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
			
		//종이컵전화기
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("========================================");
		
		System.out.println("[서버에 연결을 요청합니다.");
		socket.connect( new InetSocketAddress("192.168.0.101", 10001) );
		
		System.out.println("[서버에 연결 되었습니다.]");
		
		//쓰기 스트림
		//OutputStream out = new FileOutputStream("C:\\javaStudy\\MS949-copy.txt");
		OutputStream out = socket.getOutputStream(); //socket이 주스트림을 만들어서 달라고하며됨
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
	
		//읽기 스트림
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//메세지 보내기
		bw.write("황일영");
		bw.newLine();
		bw.flush();
		
		//메세지 받기
		String reMsg = br.readLine();
		System.out.println(reMsg);
		
	}

}
