package practice1;


class A{}
class B extends A{} // BA
class C extends A{} // CA

class D extends B{} // DBA
class E extends C{} // ECA
class F extends C{} // FCA 

public class instanceofMethodPreactice {
	
	// method 생성 
	public static void aMethod(Object thing) {
		// instance of 를 통해 상속관계 파악
		boolean flag = false; 
		
		// F인지 체크 
		if(thing instanceof F) {
			System.out.print("F");
			flag = true;
		}
		// E인지 체크 
		if(thing instanceof E) {
			System.out.print("E");
			flag = true;
		}
		// D인지 체크 
		if(thing instanceof D) {
			System.out.print("D");
			flag = true;
		}
		// C인지 체크 
		if(thing instanceof C) {
			System.out.print("C");
			flag = true;
		}
		// B인지 체크 
		if(thing instanceof B) {
			System.out.print("B");
			flag = true;
		}
		// A인지 체크 
		if(thing instanceof A) {
			System.out.print("A");
			flag = true;
		}
		
		//트루인게 하나도 없음..! 
		if(flag == false) {
			System.out.print("상속관계없음");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		aMethod(new A()); // A
		aMethod(new B()); // BA
		aMethod(new C()); // CA 
		aMethod(new D()); // DBA
		aMethod(new E()); // ECA
		aMethod(new F()); // F -> FCA 
		aMethod(new D()); // D -> DBA 
		
		aMethod(new String("Hello"));
	}

}
