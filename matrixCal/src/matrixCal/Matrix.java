package matrixCal;

public class Matrix {
		public static final int NOVALUE = -2147483646;
		private double[][] matrix;
		//행
		private int row;
		//열
		private int col;  
		
		//행, 열 크기 같은 생성자
		public Matrix(int equal)
		{
			this.row = equal;
			this.col = equal;
			matrix = new double[equal][equal];
			for(int i=0;i<equal;i++)
			{
				for(int j=0;j<equal;j++)
				{
					matrix[i][j] = (int)(Math.random() * 10 * Math.pow(-1, (int)Math.random()*10));
				}
			}
		}
		
		//행, 열 크기 다른생성자 
		public Matrix(int row, int col)
		{
			this.row = row;
			this.col = col;
			//행렬 생성 
			matrix = new double[row][col];
			// 랜덤배정 
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					matrix[i][j] = (int)(Math.random() * 10 * Math.pow(-1, (int)Math.random()*10));
				}
			}
		}
		
		
		//3X3 행렬 입력받는 생성자 
		public Matrix(double[][] temp) {
			this.matrix = temp;
			col = temp[0].length;
			row = temp.length;
		}
		
		// 행렬 셋팅 
		public void setMatrix(double temp[][])
		{
			this.row = temp.length;
			this.col = temp[0].length;
			this.matrix = temp;
		}
		
		// 영행렬로
		public void setZeroMatrix() {
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					matrix[i][j] = 0;
				}
			}
		}
		
		// 1행렬로 
		public void setOneMatrix() {
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					matrix[i][j] = 1;
				}
			}
		}
		
		// 단위 행렬로
		public void setUnitMatrix() {
			setZeroMatrix();
			for(int i=0;i<row;i++)
				matrix[i][i] = 1;
		}
		
		// 메트릭스 
		public double[][] getMatrix(){
			return matrix;
		}
		
		// row 가져오기 
		public int getRowSize() {
			return this.row;
		}
		
		// col 가져오기 
		public int getColSize() {
			return this.col;
		}
		
		// 0행렬 만들기
		public static Matrix zeros(int row,int col)
		{
			Matrix temp = new Matrix(row,col);
			temp.setZeroMatrix();
			return temp;
		}
		
		//ixi 0행렬 만들기 
		public static Matrix zeros(int i)
		{
			return Matrix.zeros(i,i);
		}

		// 행렬의 합 
		public static Matrix ones(int row, int col)
		{
			Matrix temp = new Matrix(row,col);
			temp.setOneMatrix();
			return temp;
		}
		
		
		// i*i 1행렬 
		public static Matrix ones(int i)
		{
			return Matrix.ones(i,i);
		}
		
		// i*i단위 행령
		public static Matrix unitMatrix(int i)
		{
			Matrix temp = new Matrix(i);
			temp.setUnitMatrix();
			return temp; 
		}
		
		
		// 행렬 모양비교 
	public static boolean equalSize(Matrix A, Matrix B)
	{
		if(A.getRowSize() == B.getRowSize() && A.getColSize() == B.getColSize())
			return true;
		else
			return false; 
	}
	
	// 행렬의 합
	public static Matrix plus(Matrix A, Matrix B)
	{
		double[][] temp = Matrix.zeros(A.row,A.col).getMatrix();
		double[][] tempA = A.getMatrix();
		double[][] tempB = B.getMatrix();
		
		// 크기 같다면 
		if(equalSize(A,B)) {
			
			// 덧셈 진행 
			for(int i=0;i<tempA.length;i++)
			{
				for(int j=0;j<tempA[0].length;j++)
				{
					temp[i][j] = tempA[i][j] + tempB[i][j];
				}
			}
			// 새 매트릭스 생성 
			return new Matrix(temp);
		}
		return new Matrix(temp);
	}
	
	// 행렬의 상수 배
	public Matrix multiply(double m) {
		Matrix temp = new Matrix(row,col);
		
		// 상수배 해주기 
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++) {
				temp.matrix[i][j] = this.matrix[i][j]*m;
			}
		}
		return temp;
	}
	
	
	//행렬의 곱 
	public Matrix multiply(Matrix gopMatrix)
	{
		double [][] temp;
		// 곱하기 위해서는 앞쪽 행렬의 열과 뒤쪽 행렬의 행이 같아야함.
		if(this.col == gopMatrix.row)
		{
			// temp 만들어주기 
			temp = Matrix.zeros(3,3).getMatrix();
			double[][] A = this.getMatrix();
			double[][] B = gopMatrix.getMatrix();
			
			// 행렬의 곱셈 진행하
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					for(int k=0;k<3;k++)
					{
						temp[i][j] += (A[i][k] * B[k][j]);
					}
				}
			}			
			return new Matrix(temp);
		}else {
			System.out.println("곱셈계산을 할 수 없습니다.");
			return Matrix.zeros(1);
		}
	}

	//역행렬
	public Matrix inversMatrix() {
		
		Matrix temp = null;
		
		// 행과 열이 같을때만, 역행렬 계산 가능 
		if(row == col)
		{
			// 0행렬 만들어주기 
			temp = Matrix.zeros(row);
			
			
			// 이중 반복문 
			for(int i=0;i<row;i++) {
				for(int j=0;j<row;j++)
				{
					// temp에 여인수 생성 
					temp.matrix[i][j] = cofactor(i,j); 
				}
			}
			
			// temp 전치 시키기 
			temp = temp.transpose(); // 전치 
			
			// det만들기 
			double det = determinant1(this);
			
			// det가 0이 아니면 역행렬 뽑아내기 가능 
			if(det!=0) {
				return temp.multiply(1.0/det);
			}
			// 역행렬 없음, 0행렬 반환 
			else {
				System.out.println("역행렬이 없습니다.");
				return Matrix.zeros(1);
			}
		}
		// 역행렬 없음, 0행렬 반환 
		else {
			System.out.println("행과 열의 크기가 같지 않습니다.");
			return Matrix.zeros(1);
		}
	}
	
	// 여인수 구하기 
	public double cofactor(int row,int col) {
		return minor(row,col).determinant()*Math.pow((-1),row+col);
	}
	
	// 전치 행렬
	public Matrix transpose() {
		Matrix tempM = new Matrix(col,row);
		double temp[][] = new double[col][row];
		
		// 전치히켜주기 
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				temp[j][i] = matrix[i][j];
			}
		}
	// 전치시켜준 행렬 tempM에 저장 
		tempM.setMatrix(temp);
		return tempM;
	}
	
	// 소행렬 구하기
	public Matrix minor(int removeRow, int removeCol) {
		
		// 소행렬 행,열 선언 
		int  minorRow =0;
		int minorCol = 0;
		
		// temp 생성 
		double temp[][] = new double[row-1][col-1];
		
		//temp에 소행렬 구해주기 
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				if(!(r==removeRow || c == removeCol)) {
					temp[minorRow][minorCol] = matrix[r][c];
					if(++minorCol >= col -1) {
						if(++minorRow<row-1) {
							minorCol=0;
						}
					}
				}
			}
		}
		return new Matrix(temp);
	}
	
	// 가우스 소거법에 의한 행렬식 계산
	public static double determinant(Matrix target) {
		
		// row,col사이즈 같을때만 가능 
		if(target.getRowSize() == target.getColSize()) {
			
			// temp 생성 
			double[][] temp = new double[target.row][target.row];
			
			// temp에 타겟 메트릭스 넣기 
			for(int i=0;i<target.row;i++) {
				for(int j=0;j<target.row;j++) {
					temp[i][j] = target.matrix[i][j];
				}
			}
			
			// temp.length만큼 반복문 진행  
			for(int n=0;n<temp.length;n++) {
				if(temp[n][n]==0) {
					for(int a=n;a<temp.length;a++) {
						if(temp[a][n]!=0) {
							for(int b=n;b<temp.length;b++) {
								temp[n][b] += temp[a][b];
							}
							break;
						}
					}
					if(temp[n][n]==0) {
						return 0;
					}
				}
				//temp.length만큼 반복문 진행   
				for(int i=n+1 ;i<temp.length;i++) {
					for(int j=temp[0].length-1;j>=n;j--) {
						temp[i][j] = temp[i][j] - temp[i][n] * temp[n][j] / temp[n][n];
					}
				}
			}
			double sum = 1;
			for(int i=0;i<temp.length;i++) {
				sum *= temp[i][i];
			}
			// 합반환 
			return sum;
		}else {
			System.out.println("행렬식을 구할 수 없습니다.");
			return NOVALUE;
		}
	}
	// 행렬식 계산
	public static double determinant1(Matrix target) {
		// 라이프니츠 공식으로 구하기  
		double det =0;
		if(target.getRowSize() == target.getColSize()) {
			double[][]A = target.getMatrix();
			if(A.length ==1) {
				return A[0][0];
			}else {
				for(int i=0;i<A[0].length;i++) {
					det+=A[0][i] * target.cofactor(0, i); 
				}
			}
			return det;
		}
		System.out.println("행렬식을 구할 수 없습니다.");
		return NOVALUE;
	}
	
	// 행렬
	public double determinant() {
		return Matrix.determinant(this);
	}
	
	// 행렬 출력 
	public void displayMatrix() {
		if(this.matrix.length <= 1)
		{
			System.out.print("출력할 수 있는 행렬이 존재하지 않습니다.\n");
			
		}else {
			for(int i = 0; i<3; i++){
	            for(int j = 0; j<3; j++){
	                    System.out.print(this.matrix[i][j] + " ");
	            }
	            System.out.println();
	    }
		}
	
		System.out.println();
		
	}
}
