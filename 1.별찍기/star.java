class E{

void m1(){
	for(int i=0; i<5; i++){
		for(int j=0; i>j; j++){
			System.out.print("* ");
		}
	System.out.println();
	}
}

void m2(){
	 for (int i = 0; i<5; i++){
         for (int j = 4; j>i; j--){
            System.out.print("  ");
         }
         for (int k = 0; k<i ; k++){
            System.out.print(" *");
         }
         System.out.println();
      }
      System.out.println();
}
void m3(){
	for(int i=4; i>0; i--){
		for(int j=0; i>j; j++){
			System.out.print("* ");
		}
		System.out.println();
	}
	System.out.println();
}

void m4(){
	for (int i = 0; i<5; i++){
         for (int j = 0; j<i; j++){
            System.out.print("  ");
         }
         for (int k = 4; k>i ; k--){
            System.out.print(" *");
         }
         System.out.println();
      }
      System.out.println();
}
	public static void main(String[] args) 
	{

		E e = new E();
		e.m1();
		e.m2();
		e.m3();
		e.m4();
	}
}
