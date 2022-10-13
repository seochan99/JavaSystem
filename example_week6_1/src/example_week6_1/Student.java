package example_week6_1;


public class Student {
	// field
	// field 값들 private static 값으로 주기 
	// name, score, gen 
	private static String name;
	private static int score;
	private static String gen;
	
	// constructor 
	Student(String name, int score, String gen){
		// static 방식으로 field값들 초기화 진행 
		Student.name = name;
		Student.score = score;
		Student.gen = gen;
	}
	
	// show method 실행 
	public static void show() {
		System.out.println(name+" scored "+score+" points in "+gen);
	}

}
