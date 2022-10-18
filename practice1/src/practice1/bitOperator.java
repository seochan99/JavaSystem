package practice1;

public class bitOperator {

	public static void main(String[] args) {
		final byte[] DNSAddr = {(byte)210, (byte)220, (byte)163, 82};
		// -46, -36, -93, 82 값이 저장
		
		// byte value저장 
		byte[] byteValue = new byte[4];
		int addr_val = 0;
		
		// for문을 이용하여 
		// 정수 변수 addr_val에 저장 
		// for 반복문 형태로 작성
		for(int i=0;i<DNSAddr.length;i++)
		{
			addr_val = DNSAddr[i];  
			byteValue[i] = (byte)addr_val;
		}
	}

}
