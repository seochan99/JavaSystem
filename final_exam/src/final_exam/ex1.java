package final_exam;

class GenericPrintHere04<Q>{
	public void PrintHere(Q vQ) {
		if(vQ instanceof Integer) {
			Integer val = (Integer)vQ;
			System.out.println(val);
		}
		if(vQ instanceof Double) {
			Double val = (Double)vQ;
			System.out.println("double Value : " + val);
		}
	}
	
}
public class ex1 {

	public static void main(String[] args) {
		GenericPrintHere04<Integer> qqq = new GenericPrintHere04<>();
		qqq.PrintHere(8811);
		GenericPrintHere04<Double> aaa = new GenericPrintHere04<>();
		aaa.PrintHere(7477.5);	
	}
}
