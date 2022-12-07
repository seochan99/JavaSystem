import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContentPaneEx01 extends JFrame{
	JButton OKButton, IgnoreButton, CancelButton;
	JLabel MessageLabel;
	
	public ContentPaneEx01() {
		setTitle("ContentPane and JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.orange);
		contentPane.setLayout(new FlowLayout());
		
		OKButton = new JButton("OK");
		CancelButton = new JButton("Cancel");
		IgnoreButton = new JButton("Ignore");
		MessageLabel = new JLabel("OK");
		
		
		contentPane.add(OKButton);
		contentPane.add(CancelButton);
		contentPane.add(IgnoreButton);
		contentPane.add(MessageLabel);
		
		//OKButton.addActionListener(new OKButtonActionListenr());
		// 무명 클래스 
//	OKButton.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			JButton b = (JButton)e.getSource();
//			if(b.getText() == "OK") {
//				b.setText("YES");
//			}else {
//				b.setText("OK");
//			}
//			MessageLabel.setText(b.getText());
//		}
//	});
		// 람다함수 
	OKButton.addActionListener(e -> {
		JButton b = (JButton)e.getSource();
		if(b.getText() == "OK") {
			b.setText("YES");
		}else {
			b.setText("OK");
		}
		MessageLabel.setText(b.getText()); 
	});
	
		setSize(300,150);
		setVisible(true);
	}
	

//	private class OKButtonActionListenr implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			JButton b = (JButton)e.getSource();
//			if(b.getText() == "OK") {
//				b.setText("YES");
//			}else {
//				b.setText("OK");
//			}
//			ContentPaneEx01.this.MessageLabel.setText(b.getText()); 
//		}
//		
//		}
	
	public static void main(String[] args) {
		new ContentPaneEx01(); //생성자 호출 
	}

}
//// 외부클래스
//class OKButtonActionListenr implements ActionListener{
//	JLabel messageLabel;
//	// 생성자 
//	public OKButtonActionListenr(JLabel msgLabel) {
//		messageLabel = msgLabel;
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton b = (JButton)e.getSource();
//		if(b.getText() == "OK") {
//			b.setText("YES");
//		}else {
//			b.setText("OK");
//		}
//		messageLabel.setText(b.getText());
//		
//	}
//}