package example_week5_1;

import java.util.Scanner;
import java.util.StringTokenizer;


public class week5_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력해주세요.");
		
		// 문자열입력받기 
		String munja = sc.next();
		
		
		// 컴마로 문자열 쪼개주기 
		StringTokenizer stk = new StringTokenizer(munja,",");
		
		// 남아있는 토큰 개수만큼 반환 
		int num = stk.countTokens();
		
		// num큼의 새 문자열 생성 
		String arr[] = new String[num];
				
		
		for(int i=0;i<num;i++)
		{
			 
			// 아직 토근에는 {,}와 같은숫자가 아닌 값들이 저장되어있음
			// 그렇기에 정규식 사용해서 replaceAll, [^0-9] 정규식 사용해 숫자 외 문자 모두 제거 후 arr에 넣 
			arr[i] = stk.nextToken().replaceAll("[^0-9]", "");
			
			// 문자열 출
			System.out.print(arr[i]+" ");
		}
		
		//스캐너 닫기 
		sc.close(); 

	}

}
