package fileIO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class input {
	public static void main(String[] args) {
		// Scanner
		Scanner sc = new Scanner(System.in);
		
		
		// ArrayList 선언
		// beforeList : 초기에 입력된 값 저장하는 배열 
		// afterList : beforeList에서 3의 배수인 값을 저장할 열 
		ArrayList<Integer> beforeList = new ArrayList<>();
		ArrayList<Integer> afterList = new ArrayList<>();
		
		// 데이터 변수  
		int data;
		
		System.out.print("Input : ");
		try {
			// 배열 입력 받기 반복문 
			for(int i=0;i<10;i++)
			{
				// data 변수에 정수 입력받기 
				
				data = sc.nextInt();
				
				//  3으로 나눠떨어지는 수만 리스트에 넣음
				if( data%3 == 0) {
					// data 변수 리스트에 넣어주기
					beforeList.add(data);	
				}
				// 3으로 나눠지지 않으면 리스트에 안넣음 
				else {
					continue;
				}
				
			}
		}catch(InputMismatchException e) {
			
		}
	
		
		//정수 입력안됐을때 예외처리
		
		// 배열보다 더 많은 값 입력됐을때 예외처리 

		
		
		// 오름차순 정렬(Collections.sort사용) 
		Collections.sort(beforeList);
		
		
		
		//출력
		System.out.print("Output :");
		
		// get(i),for문으로 ArrayList 요소별로 가져오
		for(int i=0;i<beforeList.size();i++)
		{
			System.out.print(" "+beforeList.get(i));
		}
		
	}

}
