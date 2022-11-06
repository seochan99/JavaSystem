import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentManager {

	public static void main(String[] args) {
		       
		// Student Class => getter, setter method 포함
		// Student Class Collection or Map save 가능 
	    File outFile = new File("/Users/seochan/Documents/Github/JavaSystem/example_week9_1/src/output.txt");

		// 결과 : 배열 or ArrayList에 저장 -> output.txt 출력 
			try {
				// 스캐너 클래스를 이용, 파일의 텍스트를 delimiter를 이용하여 자르기 위해 
				// input.txt를 입력받음 
				Scanner sc = new Scanner(new File("/Users/seochan/Documents/Github/JavaSystem/example_week9_1/src/input.txt"));
				
				// 결과 저장 ArrayList : studentArray 
				ArrayList<Student> studentArray = new ArrayList<Student>();

				// 첫줄 "이름 학번 중간 기말 총점 성적" 저장  
				String firstLine = sc.nextLine();
				
				
				
				String name ="";
				int code = 0, mid =0, kimal=0;
				
				// input.txt입력받은 값을 Student 클래스타입을 가진 배열 studentArray 요소에 저장
				// 즉,학생 한명마다 하나의배열 요소 차지함
				// ex..)
				// 0번째 학생 : studentArray의 0번째
				// 0번째 학생의 이름 : studentArray의 0번째.name
				// 와 같이 저장하기 위해 아래 반문 실행 
				
				// 학생 정보체크를 위한 i 선언
				// hasNext, 반복문 
				int i =0;
				
				// hasNext : 
		        while (sc.hasNext()) {
		        	
		        	// next() method 
		        	// => default delimiter ' '
		        	// => 공백으로 쪼갬 
		        	// =>단어 단위로 읽어 올 수 있
		        	if(i==0) { // i==0ㅣ면 이면 name
		        		name = sc.next(); 
		        	}else if(i==1) { // i==1이면 학번 
		        		String stringCode = sc.next();
		        		// string to integer 
		        		code = Integer.valueOf(stringCode).intValue(); 
		        	}else if(i==2) {
		        		//2이면 중간고사 
		        		String stringMid = sc.next();
		        		// string to integer 
		        		mid = Integer.valueOf(stringMid).intValue();
		        		
		        	}else if(i==3) {
		        		//3이면 기고사 
		        		String stringKimal = sc.next();
		        		// string to integer 
		        		kimal = Integer.valueOf(stringKimal).intValue();
		        	}
		        	
		        	// i올려주기 
		        	i++;
		        	
		        	// i가 4라면,정보 모두 얻음, 객체 생성 가능 
		        	if(i==4) {
		        		// 객체 생성 
		        		studentArray.add(new Student(name,code,mid,kimal));
		        		i=0; // i초기화  
		        	}
		        }
		        
		        //파일 작성,FileWriter가 outFile가져옴  
		        FileWriter fw = new FileWriter(outFile);
		        
		        // 첫줄 출력 후 개행 
		        fw.write(firstLine+"\n");
		        
		        for(int k=0;k<studentArray.size();k++)
		        {
		        	// 객체 total set하기  
		        	studentArray.get(k).setTotal();
		        	
		        	// 객체 rank 가져오기 
		        	studentArray.get(k).getResult();
		        	
		        	//k번째 객체 Name,code,mid,kimal을 가져와서 파일에 작성하기 
		        	fw.write(studentArray.get(k).name+" ");
		        	fw.write(studentArray.get(k).code+" ");
		        	fw.write(studentArray.get(k).mid+" ");
		        	fw.write(studentArray.get(k).kimal+" ");
		        	fw.write(studentArray.get(k).total+" ");
		        	fw.write(studentArray.get(k).rank+" "+"\n");
		        	
		        	// 파일 생성완료 여를 알기 위한 코드 
		        	System.out.println(k+" 파일 생성완");
		        }
		        // FileWriter 닫아주기 
		       fw.close();
		        
			}// 파일 못찾을 시 예외처리 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 파일 생성 예외처리  
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
