package methodTest;

public class HelloCommandLineArguments {

	public static void main(String[] args) {
		// estr = args(main에 전달받은 문자열)
		for(String estr : args) { 
			System.out.print(estr+"/");
		}
		System.out.println();
		
		// args 문자열 길이만큼 반복
		for(int i=0;i<args.length;i++)  
		{
			System.out.print(args[i]+"/");
		}
		System.out.println();

	}

}
