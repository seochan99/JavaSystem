package practice1;


// 100퍼센트 추상클래스
// 모든 메소드가 추상 메소드
// 데이터는 클래스 상수만 가능 
// JAVA 8 부터 default, static -> body 구현
// 
// object 생성 불가 
interface Area4{
	// static 메소드는 오버라이드 불가능! 
	// 상속클래스에서 보여주지않음!
	// 자신의 class내에서만 불러올 수 있는 method 
	// default가 무거워지지 않게 내용을 뺄려고! 
	
	static void calc3()
	{
		System.out.println("calc3() in interface Area4");
	}
	
	private void calc4()
	{
		System.out.println("calc4() in interface Area4");
		calc3();
	}

	default void calc2()
	{
		System.out.println("calc2() in interface Area4");
		calc4();
		
	}
	
	void calc1();
}

interface Volume4{
	// default는 같은 패키지면 상속이든~아니든~ 상관없음 
	default void calc2() {
		System.out.println("calc2() in interface Volume4");
	}
	void calc1();
}

class Exercise4 implements Area4, Volume4{
	
	@Override
	public void calc1() {
		System.out.println("calc1() in Exercise4 class");
		
	}
	@Override
	public void calc2() {
		Volume4.super.calc2();
		Area4.super.calc2();
	}
}

public class RealizationOfExercise4 {
	static {
		System.out.println("RealizationOfExercise4");
	}

	public static void main(String[] args) {
		Exercise4 ex4_0 = new Exercise4();
		ex4_0.calc2();
		
		//다형성 Excercise4 class가 Area4처럼 행세, 오버라이딩했다면 오버라이딩한걸 가져
		// 인터페이스로는 객체 생성 불가 
		Area4 ex4_1 = new Exercise4();
		// static이라서 못불러옴 
		// 다형성 
		// 
		// static method는 interface helper message 
		// interface 
		
		ex4_1.calc2();
		ex4_1.calc3();
		
		// 인터페이스 -> 
		// g
		Area4.calc3();
		
		Volume4 ex4_2 = new Exercise4();
		ex4_2.calc2();
		

	}

}
