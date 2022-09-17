import java.util.Scanner;

public class MoenyScan {
	public static void main(String[] args) {
		System.out.print("정수의 돈을 입력해주세요.");
		Scanner scanner = new Scanner(System.in);
		
		// 돈 입력받음 
		int money = scanner.nextInt();
		
		int oman = 0;
		int man = 0;
		int ocheon = 0;
	    int cheon = 0;
	    int obeak = 0;
	    int beak = 0;
	    int oship = 0;
	    int ship = 0;
	    int one = 0;
	    
	    // 돈계산 
	    oman = money / 50000;
	    man = money % 50000 / 10000;
	    ocheon = money % 50000 % 10000 / 5000;
	    cheon = money % 50000 % 10000 % 5000 / 1000;
	    obeak = money % 50000 % 10000 % 5000 % 1000 / 500;
	    beak = money % 50000 % 10000 % 5000 % 1000 % 500 / 100;
	    oship =  money % 50000 % 10000 % 5000 % 1000 % 500 % 100 / 50;
	    ship =  money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 / 10;
	    one = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 % 10 / 1; 
	           
	    // 출력 
	    System.out.println("\n오만원 : "+oman);
	    System.out.println("만원 : "+man);
	    System.out.println("오천원 : "+ocheon);
	    System.out.println("천원 : "+cheon);
	    System.out.println("오백원 : "+obeak);
	    System.out.println("백원 : "+beak);
	    System.out.println("오십원 : "+oship);
	    System.out.println("십원 : "+ship);
	    System.out.println("일원 : "+one);
	
	    
		// 스캐너 닫아주기 
		scanner.close();
	}
}
