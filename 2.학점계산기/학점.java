import java.util.Scanner;

/*class ��������
{
	int sum = 0;
		
	void m1(){
	
		int i = 100; //��������
		int j = 100; //��������
		int k = 100; //��������
		int l = 100; //��������

		sum = args[0] + args[1] + args[2] + args[3]; //����
		int a = sum/4; //���
		String grade = m2(a); //����
		System.out.println("����: " + sum + ", ���: " +a + ", ���� : " + grade);
		}
	String m2(int a){
		if(a>=90) return "A";
		else if(a>=80) return "B";
		else if(a>=70) return "C";
		else if(a>=60) return "D";
		else return "F";
	}
}
*/
class ���� 
{
	public static void main(String[] args) 
	{
		if(args.length != 4){
			System.out.println("����>java ���� �������� �������� �������� ��������");
			return;
		}
		int sum = 0;
		int ag = 0;

		System.out.println("����: " + args[0]);
		System.out.println("����: " + args[1]);
		System.out.println("����: " + args[2]);
		System.out.println("����: " + args[3]);

		int i1 = Integer.parseInt(args[0]); //���ڿ��� ���������� ���� �� �ְ� ��ȯ
		int i2 = Integer.parseInt(args[1]);
		int i3 = Integer.parseInt(args[2]);
		int i4 = Integer.parseInt(args[3]);
		sum += i1 + i2 + i3 +i4; // +=  sum = sum + i1 + i2 + i3 +i4;
		System.out.println("���� : " + sum);
		ag = sum/4;
		System.out.println("��� : " + ag);
		

		if(ag>=90){
			System.out.println("������ A�Դϴ�");
		}
		else if(ag>=80){
			System.out.println("������ B�Դϴ�");
		}
		else if(ag>=70){
			System.out.println("������ C�Դϴ�");
		}
		else if(ag>=60){
			System.out.println("������ D�Դϴ�");
		}
		else {
			System.out.println("������ F�Դϴ�");
		}
	}
}