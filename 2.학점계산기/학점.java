import java.util.Scanner;

/*class 학점계산기
{
	int sum = 0;
		
	void m1(){
	
		int i = 100; //국어점수
		int j = 100; //수학점수
		int k = 100; //영어점수
		int l = 100; //과학점수

		sum = args[0] + args[1] + args[2] + args[3]; //총점
		int a = sum/4; //평균
		String grade = m2(a); //학점
		System.out.println("총점: " + sum + ", 평균: " +a + ", 학점 : " + grade);
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
class 학점 
{
	public static void main(String[] args) 
	{
		if(args.length != 4){
			System.out.println("사용법>java 학점 국어점수 수학점수 영어점수 과학점수");
			return;
		}
		int sum = 0;
		int ag = 0;

		System.out.println("국어: " + args[0]);
		System.out.println("수학: " + args[1]);
		System.out.println("영어: " + args[2]);
		System.out.println("과학: " + args[3]);

		int i1 = Integer.parseInt(args[0]); //문자열을 정수형으로 읽을 수 있게 변환
		int i2 = Integer.parseInt(args[1]);
		int i3 = Integer.parseInt(args[2]);
		int i4 = Integer.parseInt(args[3]);
		sum += i1 + i2 + i3 +i4; // +=  sum = sum + i1 + i2 + i3 +i4;
		System.out.println("총점 : " + sum);
		ag = sum/4;
		System.out.println("평균 : " + ag);
		

		if(ag>=90){
			System.out.println("학점은 A입니다");
		}
		else if(ag>=80){
			System.out.println("학점은 B입니다");
		}
		else if(ag>=70){
			System.out.println("학점은 C입니다");
		}
		else if(ag>=60){
			System.out.println("학점은 D입니다");
		}
		else {
			System.out.println("학점은 F입니다");
		}
	}
}