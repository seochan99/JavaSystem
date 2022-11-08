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
	boolean kimalFlag; // 기말 에러 체크 깃발 
	boolean midFlag;  // 중간 에러 체크 깃발 

	// 생성자, 이름, 학번, 중간, 기말, 중간 에러 깃발, 기말 에러 깃발을 생성시 입력 받음  
	Student (String name, int code, int mid, int kimal, boolean midFlag, boolean kimalFlag){
		this.name = name;
		this.code = code;
		this.mid = mid;
		this.kimal = kimal;
		this.kimalFlag = kimalFlag;
		this.midFlag = midFlag;
	}

	// 총점수 kimal+mid로 total set하기 
	public void setTotal() {
		total = kimal + mid;
	}
	
	// total 점수에 따라 A,B,C 링크 get하기  
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
