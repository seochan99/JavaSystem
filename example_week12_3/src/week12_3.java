import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class week12_3 extends JFrame{
    private int[] unit={50000,10000,1000,500,100,50,10,1};
    
    private String[] str={"금액", "오만원", "만원","천원","500원","100원","50원","10원","1원"};
    
    private JTextField[] TextField = new JTextField[str.length];
    
    private JCheckBox[] checkbox=new JCheckBox[unit.length-1];

    public week12_3() {
    	 setTitle("Money Changer");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Container c= getContentPane();
         c.setBackground(Color.PINK);
         c.setLayout(null);

         JLabel label=new JLabel(str[0]);
         label.setSize(40,20);
         label.setLocation(40,20);
         c.add(label);

         TextField[0]=new JTextField(30);
         TextField[0].setSize(100,20);
         TextField[0].setLocation(100,20);
         c.add(TextField[0]);

         JButton btn = new JButton("계산");
         btn.setSize(70,20);
         btn.setLocation(213,20);
         btn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String input = TextField[0].getText();
                 if(input.length()==0)
                     return;

                 int money =Integer.parseInt(input);
                 int m;

                 for(int i=0;i<unit.length;i++)
                 {
                     if(i==unit.length-1)
                     {
                         m=money/unit[i];
                         TextField[i+1].setText(Integer.toString(m));
                         break;
                     }

                     if(!checkbox[i].isSelected())
                     {
                         TextField[i+1].setText("0");
                         continue;
                     }

                     m=money/unit[i];
                     TextField[i+1].setText(Integer.toString(m));

                     if(m>0)
                         money=money%unit[i];
                 }
             }
         });
         add(btn);

         for(int i=1;i<str.length;i++)
         {
             label = new JLabel(str[i]);
             label.setHorizontalAlignment(JLabel.RIGHT);
             label.setSize(50,20);
             label.setLocation(50, 30+(i*20));

             TextField[i]=new JTextField(30);
             TextField[i].setHorizontalAlignment(JTextField.CENTER);
             TextField[i].setSize(70,20);
             TextField[i].setLocation(120,30+(i*20));

             add(label);
             add(TextField[i]);

             if(i<str.length-1)
             {
                 checkbox[i-1]=new JCheckBox();
                 checkbox[i-1].setBackground(Color.PINK);
                 checkbox[i-1].setSize(20,20);
                 checkbox[i-1].setLocation(210, 30+(i*20));
                 add(checkbox[i-1]);
             }
         }

         setSize(300,300);
         setVisible(true);
     }
	public static void main(String[] args) {
		new week12_3();

	}

}
