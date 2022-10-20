package practice1;
import java.util.InputMismatchException;
import java.util.Scanner;

//java.lang.ArithmeticException


public class exceptionThrows{
	
	
	// static method로 작성 
	public static void exceptionSample() throws InputMismatchException{
		Scanner sc = new Scanner(System.in);
			int number1 = sc.nextInt();
			System.out.println(number1);
			sc.close();

		
	}
	
	public static void main(String[] args) {
		
		try {
			exceptionSample();
		}catch(InputMismatchException e) {
			System.out.println("에러발생!");
		}
	
	
	}

}
