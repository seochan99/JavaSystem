package example_week6_2;


public class Grade {
	// field
		// field 값들 private 
		private int math;
		private int science;
		private int english;
		
		// constructor 
		Grade(int math, int science, int english){
			//수학,과학,영어 입력받기 
			this.math = math;
			this.science = science;
			this.english = english;
		}
		// 평균값 반
		public double average() {
			// 평균 double로 반환하기 
			return (double)((this.math + this.science + this.english)/3);
		}
}


