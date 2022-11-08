import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class StudentManager {

	public static void main(String[] args) {
		       
		// output.txt파일 생성하기 
	    File outFile = new File("/Users/seochan/Documents/Github/JavaSystem/example_week9_1/src/output.txt");

		// 결과 : ArrayList에 저장 -> output.txt 출력 
			try {
				// 스캐너 클래스를 이용하여 파일가져오기, 파일의 텍스트를 delimiter를 이용하여 자르기 위해 
				// input.txt를 입력받음 
				Scanner sc = new Scanner(new File("/Users/seochan/Documents/Github/JavaSystem/example_week9_1/src/input.txt"));
				
				// 결과 저장 ArrayList : studentArray 
				ArrayList<Student> studentArray = new ArrayList<Student>();

				// 첫줄 "이름 학번 중간 기말 총점 성적" 저장하고 nextLine
				String firstLine = sc.nextLine();
				
				
				// 이름, 학번, 중간, 기말 점수 저장을 위한 변수 선언 
				String name ="";
				int code = 0, mid =0, kimal=0;
				// 중간 기말 점수 체크를 위한 깃발(0~50 값 벗어난 경우 true로) 
				boolean midFlag = false, kimalFlag = false;  
				
				
				// input.txt입력받은 값을 Student 클래스타입을 가진 배열 studentArray 요소에 저장
				// 즉,학생 한명마다 하나의배열 요소 차지함
				// ex..)
				// 0번째 학생 : studentArray의 0번째
				// 0번째 학생의 이름 : studentArray의 0번째.name
				// 와 같이 저장하기 위해 아래 반문 실행 
				
				// 학생 정보체크를 위한 i 선언
				// 
				// 반복문 
				
				// index변수
				// i=0이면 제일 처음 가져오는 값이므로 이름 임
				// i=1 : 학번
				// i=2 : 중간 
				// i=3 : 기말 
				// i=4 : i=0~3일때 받은 이름, 학번,중간,기말 값으로 객체 생성 후 i=0으로 초기화 
				int i =0;
				
				// hasNext()는 boolean 타입으로 반환, 다음에 가져올 값이 있다면 True, 없으면 False 
		        while (sc.hasNext()) {
		        	
		        	// next() method 
		        	// => default delimiter ' '
		        	// => 공백으로 쪼갬 
		        	// => 단어 단위로 읽어 올 수 있음 
		        	if(i==0) { // i==0 이면 name
		        		name = sc.next();
		        	}else if(i==1) { // i==1이면 학번 
		        		String stringCode = sc.next();
		        		// string to integer 
		        		code = Integer.valueOf(stringCode).intValue(); 
		        	}else if(i==2) { //2이면 중간고사 
		        		String stringMid = sc.next();
		        		
		        		// string to integer 
		        		mid = Integer.valueOf(stringMid).intValue();
		        		
		        		// mid값이 1~50사이 아닐때..
		        		if(mid<0 || mid>50) {
		        			midFlag = true;
		        		}
		        		
		        		
		        	}else if(i==3) {
		        		//3이면 기말고사 
		        		String stringKimal = sc.next();
		        		// string to integer 
		        		kimal = Integer.valueOf(stringKimal).intValue();
		        		
		        		// kimal값이 1~50사이 아닐때..
		        		if(kimal<0 || kimal>50) {
		        			kimalFlag = true;
		        		}
		        	}
		        	
		        	// i올려주기 
		        	i++;
		        	
		        	// i가 4라면,정보 모두 얻음, 객체 생성 가능 
		        	if(i==4) {
		        		// 객체 생성 
		        		studentArray.add(new Student(name,code,mid,kimal,midFlag,kimalFlag));
		        		i=0; // i 초기화
		        		// 중간, 기말 점수체크 깃발 초기화 
		        		midFlag = false;
		        		kimalFlag = false;
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
		        	
		        	// 중간고사 점수가 잘못된 값 => ERROR 출력
		        	if(studentArray.get(k).midFlag == true) {
		        		fw.write("ERROR ");
		        	}else {
		        		// 중간고사 잘못된 값 아니라면 정상 출력 
		        		fw.write(studentArray.get(k).mid+" ");	
		        	}
		        	// 기말고사 점수가 잘못된 값 => ERROR 출력
		        	if(studentArray.get(k).kimalFlag == true) {
		        		fw.write("ERROR ");
		        	}else {
		        		// 기말 잘못된 값 아니라면 정상 출력 
		        		fw.write(studentArray.get(k).kimal+" ");	
		        	}
		        	
		        	//기말또는 중간고사 둘 중 하나라도 잘못 된 값이 입력됐다면 총점, 성적 산출 불가
		        	if(studentArray.get(k).kimalFlag == true || studentArray.get(k).midFlag == true) {
		        		fw.write("ERROR ");
		        		fw.write("ERROR \n");
		        	}else {
		        		fw.write(studentArray.get(k).total+" ");
			        	fw.write(studentArray.get(k).rank+" "+"\n");	
		        	}
		        	
//		        	// 파일 생성완료 여를 알기 위한 코드 
//		        	System.out.println(k+"번째 파일 생성완료");
		        }
		        // FileWriter 닫아주기 
		       fw.close();
		       
		        // 스캐너 닫아주기 
		        sc.close();
		        
			}// 파일 못찾을 시 예외처리 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} // 파일 생성 입출력 예외처리  
			catch (IOException e) {
				e.printStackTrace();
			}
	}

}
