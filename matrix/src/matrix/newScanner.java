package matrix;
import java.util.Scanner;

public class newScanner {

	public static void main(String[] args) {
		System.out.println("Type a message : ");
		Scanner sc = new Scanner(System.in);
//		java.util.Scanner sc = new java.util.Scanner(System.in);
		String message_with_scanner;
		message_with_scanner = sc.next();
		System.out.println("Message : "+message_with_scanner );
		sc.close();
		

	}

}
