import java.net.*;
import java.io.*;

//wello-known port : 0 ~ 1023 
class AServer extends Thread
{
	int port = 4000;
	ServerSocket ss;
	Socket s;
	String ipClient;
	String ipServer;

	InputStream is; //node 
	OutputStream os;
	
	DataInputStream dis; //filter 
	DataOutputStream dos;


	AServer(){
		try{
			ss = new ServerSocket(port);
			pln(port+"번 포트에서 서버 대기중...");
	
			s = ss.accept();
			ipClient = s.getInetAddress().getHostAddress();
			pln("클라이언트("+ipClient+")입장!!");
			
			is = s.getInputStream();
			os = s.getOutputStream();
			start();
			listen();
			
			
		}catch(IOException ie){
			pln("ie: " + ie);
		}finally{
			try{
				if(s != null) s.close();
				if(ss != null) s.close();
			}catch(IOException ie){}
		}
	}
	
	public void run(){
		speak();
	}


	void listen(){ //socket -> monitor 
		dis = new DataInputStream(is);
		try{
			while(true){
				String msg = dis.readUTF();
				pln("Server("+ipClient+")>> " + msg);
			}
		}catch(IOException ie){
			pln("클라이언트("+ipClient+")퇴장!!");
		}finally{
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
		new AServer();
	}
}
