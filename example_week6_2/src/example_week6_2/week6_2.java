package example_week6_2;
import java.util.Scanner;

public class week6_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수학, 과학, 영어 순으로 3개의 점수 입력 >> ");
		
		// 숫자가 입력될때까지 반복실행 
		while(true) {
			try {			
				int math = sc.nextInt();
				int science = sc.nextInt();
				int english = sc.nextInt();
				Grade me = new Grade(math,science,english);
				System.out.println("평균은 : " + me.average());
				break;
				// 숫자가 아닌 값이 입력되었을때
				
			}catch(java.util.InputMismatchException e) {
				System.out.println("ERROR : You must enter an integer");

				// 버퍼의 입력값을 제거 
				sc.nextLine();
				
				// 반복문 돌아가기
				continue;
			}
		}
		sc.close();
	}

}
