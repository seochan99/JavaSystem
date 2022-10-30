// ArrayList배열 이용 
import java.util.ArrayList;

// 입력을 위한 scanner 
import java.util.Scanner;

//정렬을 위한 Collections
import java.util.Collections;

// error
import java.util.InputMismatchException;

public class week8_1 {

	public static void main(String[] args) {

		
				// Scanner
				Scanner sc = new Scanner(System.in);
				
				// ArrayList 선언
				// list : 초기에 입력된 값 저장하는 배열 
				ArrayList<Integer> list = new ArrayList<>();
				
				// 데이터 변수  
				int data;
				
				System.out.print("Input : ");
				
					// 배열 입력 받기 반복문, 10개입력받음.
					for(int i=0;i<10;i++)
					{
						try {
						// data 변수에 정수 입력받고 리스트에 넣기 
						data = sc.nextInt();
						list.add(data);	
						}
						// 숫자 미입력시  InputMismatchException 에러, 재입력 요
						catch(InputMismatchException e) {
							System.out.println("정수가 아닙니다. 다시 입력해주세요.");
							i--; // i빼고for문으로 돌아가 다시 입력 받기 
							sc.next(); // 무한루프 방지를 위해 입력 스트림 토큰 비우기
							continue;
						}	
					}
					
					// 오름차순 정렬(Collections.sort사용) 
					Collections.sort(list);
					
					
					//출력
					System.out.print("Output :");
					
					// get(i),for문으로 ArrayList 요소별로 가져오
					for(int i=0;i<list.size();i++)
					{
						// 가져 온 요소가 3으로나눈 나머지가0이면 해당 값 출력하기 
						if(list.get(i) % 3 == 0)
							System.out.print(" "+list.get(i));
						// 그 외의 값들은 출력 x 
						else
							continue;
					}
					
					// 스캐너 닫기 
					sc.close();
				}
			
				

				

	}

