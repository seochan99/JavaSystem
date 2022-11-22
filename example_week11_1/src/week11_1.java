import javax.swing.*; //swing

public class week11_1 extends JFrame{
	//  JFrame이 serializable을 상속 받으므로아래 문구를 작성해야 
	private static final long serialVersionUID = 1L;

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
		new week11_1();

	}

}