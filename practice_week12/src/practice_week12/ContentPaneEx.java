package practice_week12;

// aws, swing import
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

// JFrame을 상속 받아야함 
public class ContentPaneEx extends JFrame{
	JButton OKButton;
	JButton IgnoreButton;
	JLabel MessageLabel;
	

	public ContentPaneEx() {
		// 이름 설정 
		setTitle("ContentPane과 JFrame");
		
		// 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//선
		OKButton = new JButton("OK");
		IgnoreButton = new JButton("Igonore");
		MessageLabel = new JLabel("");
		
		// 페이지 그리기 
		contentPane.add(OKButton);
		contentPane.add(new JButton("Cancel"));
		contentPane.add(IgnoreButton);
		contentPane.add(MessageLabel);
		
		
		// 그리기 
		OKButton.addActionListener(new OKButtonActionListener(MessageLabel));
		setSize(300, 150);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new ContentPaneEx();
	}
	

}
class OKButtonActionListener implements java.awt.event.ActionListener{
	JLabel msgLabel;
	
	// 생성자 
	public OKButtonActionListener(JLabel someLabel) {
		msgLabel = someLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// ok누를때마다 바뀌
		JButton b = (JButton)e.getSource();
		if(b.getText() == "OK") {
			b.setText("YES");
			msgLabel.setText("OK to Yes");
		}
		else {
			b.setText("OK");
			msgLabel.setText("Yes to Ok");
		}
		
		
	}
	
}
