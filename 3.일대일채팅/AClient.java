import java.net.*;
import java.io.*;

class AClient extends Thread {

	Socket s;
	String ip = "192.168.0.7"; //at home : 115.91.81.106
	String ipServer;
	String ipClient;
	int port = 4000;
	
	InputStream is;
	OutputStream os;

	DataInputStream dis;
	DataOutputStream dos;
	

	AClient(){
		try{
			s = new Socket(ip, port);
			pln("서버("+ip+")와 접속 성공!!");
			
			is = s.getInputStream();
			os = s.getOutputStream();
			start();
			listen();
			
			
		}catch(UnknownHostException ne){
			pln("네트웍에서 해당 서버("+ip+")를 찾을 수 없음");
		}catch(IOException ie){
		}finally{
			try{
				if(s != null) s.close();
			}catch(IOException ie){}
		}
	}
	

	public void run(){
		speak();
	}
	void listen(){
		dis = new DataInputStream(is);//client로부터 오는 데이터가 깨지지 않게 하기 위해 선언
		try{
			while(true){//반복문을 사용해 클라이언트가 보내는 데이터를 계속 보여주게 함.
				String msg = dis.readUTF();
				pln("client("+ip+")>>>"+msg);
			}
				}catch(IOException ie){
			pln("서버("+ip+")퇴장!!");
			}
		finally{
			try{
				if(dis != null) dis.close();
				if(is != null) is.close();
			}catch(IOException ie){}
		}
	}
	
	

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void speak(){ //keyboard -> socket 
		dos = new DataOutputStream(os);
		try{
			String msg = "";
			while(true){
				msg = br.readLine();
				dos.writeUTF(msg);
				dos.flush();
			}
		}catch(IOException ie){
			pln("speak(): "+ ie);
		}finally{
			try{
				if(dos != null) dos.close();
				if(os != null) os.close();
			}catch(IOException ie){}
		}
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		AClient c = new AClient();
	}
}
