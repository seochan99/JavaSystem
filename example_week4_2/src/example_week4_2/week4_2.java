package example_week4_2;
import java.util.Scanner;

public class week4_2 {

	public static void main(String[] args) {
		
		//스캐너 선언 
		Scanner sc = new Scanner(System.in);
		
		// 알파벳입력 받기charAt(0) : 0번째 요소 받기 
		System.out.print("소문자 알파벳 하나를 입력하시오 : ");
		char alpha = sc.next().charAt(0);
		
		// 반복문 a부터 alpha까
		for(int i=97;i<=alpha;i++) {
			
			// 반복문 j부터 alpha까지 
			for(int j=i;j<=alpha;j++)
				System.out.print((char)j + " ");
			System.out.println();
		}
		
		sc.close();
	}

}
