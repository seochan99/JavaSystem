package practice1;


interface interface_A{
	int Method_Query1();
}

// 반드시 상속해서 사용해야함.
abstract class AbstractClass_B{
	abstract boolean Method_Query ();
}

public class overriding extends AbstractClass_B implements interface_A{
	
	@Override
	public int Method_Query1() {
		return 0;
	}
	
	@Override
	public boolean Method_Query() {
		return true;
	}
	

}
