package example_week4_3;
import java.util.Scanner;

public class LetureMembers {

	public static void main(String[] args) {
		
		//스캐너 sc선언 
		Scanner sc = new Scanner(System.in);
		System.out.print("강좌의 개수를 입력해주시길 바랍니다.");
		
		
		try {
			// cos변수 Int형으로 입력받기
			int cos = sc.nextInt();
			// Int가 안들어오면 InputMismatchException로 ..
			
			// cos가 2이상 12이하 인지 체크하기 
			if(cos>=2 && cos<=12)
			{
				// cos만큼 arr배열 생성 
				int arr[][] = new int[cos][];
				
				for(int i=0;i<cos;i++)
				{
					try {
						System.out.print((i+1)+"번째 강좌 인원수를 입력해주세요. ");
						int member = sc.nextInt();
						// arr[i] 번째 열에 int형 [member]만큼 행 생
						arr[i] = new int[member];
					}
					//숫자가 입력안됐을때 예외처리 
					catch(java.util.InputMismatchException e)
					{
						System.out.println("숫자가 입력되지 않았으므로 프로그램을 종료합니다.");
						
						sc.close();
						// exit사용안하면 for문 계속 반복 
						// System.exit(0)을 통해 강제종류 
						System.exit(0);
					}
					

				}

		        for (int i = 0; i < arr.length; i++)
		        {
		        	//배열 하나 더 생성해서한줄씩 뽑아내기 
		        	int[] inArr = arr[i];

		        	for (int j = 0; j < inArr.length; j++)
		        	{                
		        		System.out.print(inArr[j] + " "); 
		        	}
		        	
		        	System.out.println(); 
		        	}
			}else 
			{
				System.out.println("2이상 12이하의 값을 입력하지 않았으므로 프로그램을 종료합니다.");
			}
			
			// 강좌별로 인원수 각각 콘솔로 입력받아 배열 생성 
			// 
			
			
			
		}
		//숫자가 입력안됐을때 예외처리 
		catch(java.util.InputMismatchException e)
		{
			System.out.println("숫자가 입력되지 않았으므로 프로그램을 종료합니다.");
		}
		sc.close();
		
		
		

	}

}
