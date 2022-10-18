package practice1;

//enum은 뒤에 콤마 안붙힘 
enum WorkingDay {Mon,Tue,Wed,Thu,Fri}

public class WorkingDayPrint {

	public static void main(String[] args) {
		
		System.out.print("Working days ( ");
		
		int cnt = 0; 
		
		for(WorkingDay wk: WorkingDay.values()) {
			
			// 형식 맞추기 
			cnt++;
			
			if(cnt==WorkingDay.values().length)
				System.out.print(wk+" )");
			else 
				System.out.print(wk+", ");
			
		}
	}

}
