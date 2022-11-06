// input.txt 파일 가져와서 여기 저장 
public class Student {
	// 이름 학번 중간 기말 총점 성적
	// name, code, mid, kimal, total, rank
	String name; // 이름 
	int code; // 학번 
	int mid; // 중간 
	int kimal; // 기말 
	int total; // 총점 
	char rank; //성적  
	
	
	// 성적은 필드 가공이 필요함 => getter 
	// why?: 총점을 기준으로 랭크를 매겨야하므로
	// 이름, 학번, 중간, 기말은 줌 
	// setter으로 받음
	
	Student (){
		
	}
	// 생성자
	Student (String name, int code, int mid, int kimal){
		this.name = name;
		this.code = code;
		this.mid = mid;
		this.kimal = kimal;
	}
	
	// 이름 setter
	public void setName(String name) {
		this.name = name; 
	}
	
	// 학번 setter 
	public void setCode(int code) {
		this.code = code;
	}
	
	// mid setter, 50점 위의 값이 입력되면...?
	public void setMid(int mid) {
		
		// 0보다 작거나 50보다 작은 값 입력되면 -1로 저장 
		if(mid>50 || mid<0) {
			System.out.print(this.name + "학생의 중간 성적이 잘못 입력되어 -1 처리 합니다.");
			this.mid = -1;
		}
		// 그 외에는 mid 저장 
		else {
			this.mid = mid;
		}
	}
	
	// kimal setter, 50점 위의 값이 입력되면...?
	public void setKimal(int kimal) {
		
		// 0보다 작거나 50보다 작은 값 입력되면 -1로 저장 
		if(kimal>50 || kimal<0) {
			this.kimal= -1; 
			System.out.print(this.name + "학생의 기말 성적이 잘못 입력되어 -1 처리 합니다.");
		}
		// 그 외에는 mid 저장 
		else {
			this.kimal = kimal;
		}
	}
	
	// 그런데.. 총점이 100점이 넘어가면 특수 값 저장해서 오류임을 알려주기
	public void setTotal() {
		total = kimal + mid;
	}
	

	public void getResult() {
		if(total>=70) {
			rank = 'A';
		}else if(total<70 && total>=50) {
			rank = 'B';
		}else {
			rank = 'C';
		}
	}
		
	

}
