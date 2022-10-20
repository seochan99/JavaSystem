package practice1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class AnnualDays {


	public static void main(String[] args) {
		//일자로 초기화하는 프로그램 작성 
		int year = 0;	
		int leap;
		int[][] isLeapYear = {
				  // 윤
				  {31,28,31,30,31,30,31,31,30,31,30,31}, //평년 
					{31,29,31,30,31,30,31,31,30,31,30,31}, // 윤년 
		  };
		  
		// 1월은 
		Scanner sc = new Scanner(System.in);
		// 일수를원소를 갖는
		// int[][] AnnualDaysByMont를 초기화 해야함.   
		int[][] AnnualDaysByMonth =new int[12][];  	
		
	       try {
	    	   
	    	   // 년도 입력받기 
	    	   System.out.println("년도를 입력해주세요.");
	    	   year = sc.nextInt();
	    	   // 윤년이면 1 -> 29일 
	    	   // 아니면 0 -> 28일 -> 평년 
	    	   leap = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1: 0;
	    	   for(int i =0;i<12;i++) {
	    		   AnnualDaysByMonth[i] = new int[isLeapYear[leap][i]];   
	    	   }
	    	   
	       }catch(InputMismatchException e){
	    	   System.out.println("숫자를 입력해주세요.");
	       }finally {
	    	   System.out.println("입력물 : " + year);
	       }
	       
	       // 출력 
	       for (int i = 0; i < AnnualDaysByMonth.length; i++)
	        {
	        	//배열 하나 더 생성해서한줄씩 뽑아내기 
	        	int[] inArr = AnnualDaysByMonth[i];

	        	for (int j = 0; j < inArr.length; j++)
	        	{                
	        		System.out.print(inArr[j] + " "); 
	        	}
	        	System.out.println(); 
	        	}

	}

}
