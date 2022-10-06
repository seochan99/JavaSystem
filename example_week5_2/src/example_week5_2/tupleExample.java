package example_week5_2;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.LinkedHashSet;



public class tupleExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					// 그렇기에 정규식 사용해서 replaceAll, [^0-9] 정규식 사용해 숫자 외 문자 모두 제거 후 arr에 넣음  
					arr[i] = stk.nextToken().replaceAll("[^0-9]", "");
				}
				

				// 배열에서 중복 제거를 위해 Set인터페이스를 구현한 클래스 이며 입력된 순서대로 데이터를 관리하는
				// linkedHash 클래스 선언, String 값  
		        LinkedHashSet<String> lhs = new LinkedHashSet<>();
		        
		        // lhs에 arr배열 요소를 넣음, 집합으로 넣어서 중복된 요소는 안들어감.
		        for(String item : arr){
		            lhs.add(item);
		        }
		        
		        // 중복제거된 값이 저장된 lhs출력 
		         System.out.println(lhs);
				
				//스캐너 닫기 
				sc.close(); 

			}

}
