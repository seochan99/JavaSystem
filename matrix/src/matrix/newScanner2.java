package matrix;
import java.util.Scanner;


public class newScanner2 {

	public static void main(String[] args) {
		System.out.println("이름, 나이, 몸무게 입력 ");
		Scanner sc = new Scanner(System.in);
		
	try {
		String name = sc.next();
		int age = sc.nextInt();
		double weight = sc.nextDouble();
		System.out.println("Message\n"+name+"\n"+age+"\n"+weight);
		
		
	}
	catch(java.util.InputMismatchException e) {
		System.out.println("NO DATA");
	}
	
		
	
	}

}
