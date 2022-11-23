import javax.swing.*;
import java.awt.*;

public class week11_2 extends JFrame{
	// 생성자 만들
	public week11_2(){
    	// 제목 설정 
        setTitle("Random Labels");
        // close operation 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 400x200 크기 
        setSize(300, 300);
        // 보이게 
        setVisible(true);
        
        // 컨텐트팬 가져오기 
        Container contentPane = getContentPane();
        // 컨테이너 레이아웃 설정 
        contentPane.setLayout(null);

        for(int i=1;i<21;i++)
        {
        	// 라벨 만들기 
        	// 발생순서대로 숫자 넣어주기 
            JLabel label=new JLabel(Integer.toString(i));
            // 기존 폰트에서는 글자크기가 커서 숫자가 다 안보임 
            // 폰트크기 8로 줄이기 
            label.setFont(label.getFont().deriveFont(8.0f));
            // x,y좌표 랜덤 
            // 랜덤함수 0~200랜덤  
            int x=(int)(Math.random()*200)+50;
            int y=(int)(Math.random()*200)+50;
            
            // 위치 설정 
            label.setLocation(x,y);
            
            // 10x10크기 
            label.setSize(10,10);
            
            // 배경색 적용을 위해 Opaque값을 true로 설정 
            label.setOpaque(true);
            // 파란색 설정 
            label.setBackground(Color.blue);

            // 컨테이너에 라벨 넣기 
            contentPane.add(label);
        }
	}

	public static void main(String[] args) {
		// 객체 생성 
		new week11_2();
		

	}

}
