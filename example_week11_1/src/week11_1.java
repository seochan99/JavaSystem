import javax.swing.*; //swing

public class week11_1 extends JFrame{

	// 생성자 호출 
    public week11_1(){
    	// 제목 설정 
        setTitle("Let’s study Java");
        // close operation 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 400x200 크기 
        setSize(400, 200);
        // 보이게 
        setVisible(true);
    }
    
	public static void main(String[] args) {
		// 객체 생성 
		new week11_1();
	}

}