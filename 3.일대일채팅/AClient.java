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
			pln("����("+ip+")�� ���� ����!!");
			
			is = s.getInputStream();
			os = s.getOutputStream();
			start();
			listen();
			
			
		}catch(UnknownHostException ne){
			pln("��Ʈ������ �ش� ����("+ip+")�� ã�� �� ����");
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
		dis = new DataInputStream(is);//client�κ��� ���� �����Ͱ� ������ �ʰ� �ϱ� ���� ����
		try{
			while(true){//�ݺ����� ����� Ŭ���̾�Ʈ�� ������ �����͸� ��� �����ְ� ��.
				String msg = dis.readUTF();
				pln("client("+ip+")>>>"+msg);
			}
				}catch(IOException ie){
			pln("����("+ip+")����!!");
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
