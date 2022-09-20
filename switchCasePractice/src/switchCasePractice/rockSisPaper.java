package switchCasePractice;
import java.util.Scanner;

public class rockSisPaper {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String choice = scanner.next();
		
		switch (choice) {
			case "가위" :
				System.out.println(1);
				break;
			case "바위" :
				System.out.println(2);
				break;
			case "보" :
				System.out.println(3);
				break;
			default:
				System.out.println(0);
			}
		scanner.close();
	}

}



