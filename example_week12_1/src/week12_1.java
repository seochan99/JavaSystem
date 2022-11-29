import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class week12_1 extends JFrame {

	// StringBuffer에 담기  
	StringBuffer sb=new StringBuffer("Love Java");
	
	// 담은 값 String으로 만들어서 라벨 생성해서 label에 넣
	// StringBuffer형 String으로 형 변환 
    JLabel label = new JLabel(sb.toString());

    public week12_1()
    {
    	// 제목 설정 
        setTitle("Left 키로 문자열 뒤집기");
        
        // 나가기  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 콘테이너 생성 
        Container c = getContentPane();
        
        // layout설정, 
        c.setLayout(new FlowLayout());

        // KeyListener()를 사용하면 keyPressed, Released, Typed 인터페이스 전부를 완성해야함
        // KeyAdapter는 위 세개 모두 정의 되어있기에 필요한거 재정의만 하면 됨
        // 익명 클래스로 작성 => 클래스 정의부분과 인스턴스 생성 부분 하나합침 
        label.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
            	// 내부 클래스를 통해 현재 객체의참조 모두 이용 가능
            	// 왼쪽 화살표를 누른 경우 label.setText 
                if(e.getKeyCode()==KeyEvent.VK_LEFT)
                    label.setText(sb.reverse().toString());
            }
        });

        // 라벨 추가 
        c.add(label);
        //크기 설정 
        setSize(300,120);
        // 창을 화면에 나타냄 
        setVisible(true);

        // 키 이벤트는 포커스가 위치해 있어야 키 이벤트가 발생, 그러므로 강제로 포커스 설
        //포커스를 받을 수 있는 컴포트가 여러개 일수도 있으므로 
        // setFocusable(true); 를 통해 이 컴포넌트 먼저 키 입력받도록 진행 
        label.requestFocus();
        label.setFocusable(true);
        
    }

    public static void main(String[] args)
    {
    	// 객체 생
        new week12_1();
    }
}