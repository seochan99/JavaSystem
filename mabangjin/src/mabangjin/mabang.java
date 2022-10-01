package mabangjin;
import java.util.Scanner;


public class mabang {

	public static void main(String[] args) {
		
		// 마방진 배열 선언 
		 int magicSquare[][];
		 
		 
         int val = 1;
         int num = 0;
         int row = 0, col =0;    
         System.out.println("******* 마방진 생성기 *******");
         System.out.print("5이상의 홀수 숫자를 입력해주세요! : ");
         

         Scanner sc = new Scanner(System.in);
         num = sc.nextInt();
         
         // 1행 중앙에넣기 위해 
         col = num/2;
         
         // 마방진 2차원 배열 생성 
         magicSquare =  new int[num][num];
        
         
         // 반복문 val이 num*n보다 이하일때까지 반복
         // val이 1씩 증가하므로 num*num 모든 상자를 채우면 num*n의 값을 가진다. 
         while(val <= num*num){
                 magicSquare[row][col] = val;
                
                 // 우측대각선에 값이 이미 있는 경우 
                 if(val % num == 0){
                         row++;
                 }else{
                	 // 열 감소, 행 증가 
                         row--;
                         col++;
                 }
                 // 열이 0보다 작을때 
                 if(row < 0)
                	 // 열은 num-1로 
                         row = num-1;
                 // 열이 n이상일
                 if(row >= num)
                	 // 열은 0으로 
                         row = 0;
                 //행이 0보다 작을때 
                 if(col < 0)
                	 // 행은 num-1로 
                         col = num-1;
                 // 행이 num 이상일
                 if(col >= num)
                	 //행은 0으로 
                         col = 0;
                 
                 // 행,열 이동 후 val값 올려주기 
                 val++;
         }
        
         
         // 마방진 출력 
         for(int i = 0; i<num; i++){
                 for(int j = 0; j<num; j++){
                         System.out.print(magicSquare[i][j] + " ");
                 }
                 System.out.println();
         }

         sc.close();
	}
	

}
