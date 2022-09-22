package matrix;

import java.io.IOException;

public class system_in {

	public static void main(String[] args) {
		byte[] messageFromKeyboard = new byte[256];
		
		System.out.println("Type a Message : ");
		//키보드 입력을 바로 저장하니깐// raw 데이터처럼 써먹기 가능// 이렇게 입력받아야하는곳에서는 scanner보다는 이 방식이더좋음 
		
		// 
		try {
			System.in.read(messageFromKeyboard);	
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
		for(int i=0;i<messageFromKeyboard.length;i++)
		{
			
			System.out.println(messageFromKeyboard[i]);
			System.out.println(new String(messageFromKeyboard));
			
		}
		

	}

	
}
