public class HeronsMethod {

	public static void main(String[] args) {
		double a=9.0, b=7.0, c=1.0;
		double s = (a+b+c)/2.0;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
				

		System.out.println("세 변의 길이가 " + a + ", "+b+", "+c+" 인 삼각형의 넓이는 "+ area + "입니다.");

	}

}
