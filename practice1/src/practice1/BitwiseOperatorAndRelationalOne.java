package practice1;

public class BitwiseOperatorAndRelationalOne {

	public static void main(String[] args) {
		
		int x =0;
		System.out.println("case (1) : ++x > 0 | x++ < 1");
		if(++x > 0 | x++ < 1)
			System.out.println("yes");
		else
			System.out.println("No");
		
		System.out.println("x = " + x);
		
		System.out.println("case (2): ++x > 0 || x++ < 1 ");
		x = 0;
		if(++x>0 || x++ <1)
			System.out.println("yes");
		else
			System.out.println("no");
		
		System.out.println("x = " + x);
		
	}

}
