package matrixCal;


// 3x3 정방행렬만 입력받음. 
public class matrixExample {

	public static void main(String[] args) {
		
	double [][] arr0= {{0,0,0},{0,0,0},{0,0,0}};
	double [][] arr1= {{1,1,1},{2,2,2},{3,3,3}};
	double [][] arr2= {{1,2,3},{1,2,3},{1,2,3}};
	
	// A,B행렬 생성 
	Matrix matrixA = new Matrix(arr1);
	Matrix matrixB = new Matrix(arr2);
	
	// 더하기, 곱하기, 역, 단위행렬 저장을 위한 객체 생성 
	Matrix AddMatrix = new Matrix(arr0);
	Matrix MulMatrix = new Matrix(arr0);
	Matrix InverseMatrix = new Matrix(arr0);
	Matrix DanWiMatrix = new Matrix(arr0);
	
//	 행렬 덧셈
	System.out.println("[A + B 행렬의 덧셈]");
	AddMatrix = Matrix.plus(matrixB,matrixA);
	AddMatrix.displayMatrix();
	
	//덧셈도 굿 
	
//	행렬의 곱 
	System.out.println("[A X B 행렬의 곱]");
	MulMatrix = matrixA.multiply(matrixB);
	MulMatrix.displayMatrix();
	
	
	
// A행열의  역행렬
	System.out.println("[A의 역행렬]");
	InverseMatrix = matrixA.inversMatrix();
	InverseMatrix.displayMatrix();

//	A 역행렬 X matrixA = 단위행렬
	System.out.println("[A의 역행렬 X A = 단위행렬]");
	DanWiMatrix = matrixA.multiply(InverseMatrix);
	DanWiMatrix.displayMatrix();
	}

}
