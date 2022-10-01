package matrixCal;


// 3x3 정방행렬만 입력받음. 
public class matrixExample {

	public static void main(String[] args) {
	double [][] arr0= {{0,0,0},{0,0,0},{0,0,0}};
	double [][] arr1= {{1,1,0},{1,0,1},{0,1,0}};
	double [][] arr2= {{1,-2,4},{-5,2,0},{1,0,3}};
	
	Matrix m1 = new Matrix(arr1);
	
//    System.out.println(Arrays.deepToString(arr1));
	
	Matrix AddMatrix = new Matrix(arr0);
	Matrix MulMatrix = new Matrix(arr0);
	Matrix InverseMatrix = new Matrix(arr0);
	Matrix DanWiMatrix = new Matrix(arr0);
	
	Matrix m2 = new Matrix(arr2);
	
//	 행렬 덧셈
	System.out.println("[A + B 행렬의 덧셈]");
	AddMatrix = Matrix.plus(m2,m1);
	AddMatrix.displayMatrix();
	
	//덧셈도 굿 
	
//	행렬의 곱 
	System.out.println("[A X B 행렬의 곱]");
	MulMatrix = m1.multiply(m2);
	MulMatrix.displayMatrix();
	
	
	
//	 m1행열의  역행렬
	System.out.println("[A의 역행렬]");
	InverseMatrix = m1.inverse1();
	InverseMatrix.displayMatrix();

//	역행렬 X m1 = 단위행렬
	System.out.println("[A의 역행렬 X A = 단위행렬]");
	DanWiMatrix = m1.multiply(InverseMatrix);
	DanWiMatrix.displayMatrix();
	}

}
