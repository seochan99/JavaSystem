package matrix;

public class matrixP {

	public static void main(String[] args) {
        int[][] arr = { { 1}, { 1,2,3 }, {1},{ 1,2,3 ,4},{ 1,2 }};
        
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
	}
}