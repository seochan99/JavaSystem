import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContentPaneEx02 extends JFrame{
	JButton OKButton, IgnoreButton, CancelButton;
	JLabel MessageLabel;
	
	public ContentPaneEx02() {
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
		
		OKButton.addActionListener( e->{
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

	public static void main(String[] args) {
		new ContentPaneEx01(); //생성자 호출 
	}

}