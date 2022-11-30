import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class week12_3 extends JFrame{

	// 돈 int 
    private int[] moneyInt={50000,10000,5000,1000,500,100,50,10,1};
    
    // 돈 string 
    private String[] moneyStr={"금액", "오만원", "만원","오천원","천원","500원","100원","50원","10원","1원"};
    
    // str로 text 입력받기 
    //textfiled string만큼 만들기 
    private JTextField[] InputField = new JTextField[moneyStr.length];

    // checkbox 생성 1원은 제외하므로 moneyInt.length-1만큼 
    private JCheckBox[] cb=new JCheckBox[moneyInt.length-1];

       

    public week12_3() {
    	// title
    	 setTitle("Money Changer");
    	 
    	 // default close operation 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         // container 
         Container c= getContentPane();
         
         // layout 설정 
         c.setLayout(null);
         
         // background color 
         c.setBackground(Color.PINK);

         // Label 생성, 크기, 위치 설정  
         JLabel label=new JLabel(moneyStr[0]);
         label.setBounds(43, 20, 43, 20);
         // 라벨 컨테이너에 추가 
         c.add(label);
 

         //입력 텍스트 필드 생성, 크기, 위치 설정,  
         InputField[0]=new JTextField("금액 입력");
         InputField[0].setBounds(90, 20, 100, 20);
         // 입력 텍스트 컨테이너에 추가
         c.add(InputField[0]);
         
         
         // 계산 버튼 생성, 크기, 위치 설정 
         JButton btn = new JButton("계산");
         btn.setBounds(205, 20, 73, 20);
         
         //버튼 클릭시 동작리스너 설정  
         btn.addActionListener(new ActionListener() {
        	 
             @Override
             public void actionPerformed(ActionEvent e) {               
                 try {
                	  // moeny에 입력한 돈 interger형으로 저장하기 
                     int money =Integer.parseInt(InputField[0].getText());
                     int cnt;

                     // 계산 알고리즘, 돈 정수형 만큼 반복진행 
                     for(int i=0;i<moneyInt.length;i++)
                     {
                    	 // i가 돈의 길이 마지막에 왔을때 
                         if(i==moneyInt.length-1)
                         {
                        	 //전부 1원으로 변환 
                             cnt=money/moneyInt[i];
                             InputField[i+1].setText(Integer.toString(cnt));
                             break;
                         }

                         // 체크박스가 선택되어 있지 않는 필드는 0으로 셋팅하고 반복문 다시 돌아가
                         if(!cb[i].isSelected())
                         {
                             InputField[i+1].setText("0");
                             continue;
                         }

                         // cnt는 입력된 돈 / moneyInt에 저장되어 있는 값
                         cnt=money/moneyInt[i];
                         
                         // 해당 cnt를 해당textfiled에 넣기
                         InputField[i+1].setText(Integer.toString(cnt));

                         // cnt가 0보다 크면 
                         if(cnt>0)
                             money=money%moneyInt[i];
                     }
                     // 숫자 외의 값을 입력하고확인을 눌렸을경우 예외처리 
                 }catch(NumberFormatException err) {
                	 // 정수를 눌려달라고 하는 안내문 뜸 
                	JOptionPane.showMessageDialog(null,"정수를 입력해주세요!");
                 }
               
             }
         });
         c.add(btn);

         // 라벨 붙이기 
         for(int i=1;i<moneyStr.length;i++)
         {
        	 // 글자 라벨 생성
             label = new JLabel(moneyStr[i]);
             label.setHorizontalAlignment(JLabel.RIGHT);
             // 위치, 크기 설정 
             label.setBounds(50, 30+(i*19), 50, 20);
             
             // textfield 생성,라벨 가운데 정렬 진행, 크기위치 설정, 초기 0 설정  
             InputField[i]=new JTextField("0");
             InputField[i].setHorizontalAlignment(JTextField.CENTER);
             InputField[i].setBounds(120,30+(i*19),70,20);
             // 라벨, 필드 추가하
             c.add(label);
             c.add(InputField[i]);
             
             // moenyStr이 1원이기 전까지체크박스 생성 
             if(i<moneyStr.length-1)
             {
                 cb[i-1]=new JCheckBox();
                 cb[i-1].setBounds(210, 30+(i*19), 20, 20);
                 c.add(cb[i-1]);
             }
         }

         // 위치, 크기 설정 
         setBounds(700,400,300,300);
         setVisible(true);
     }
	public static void main(String[] args) {
		// 객체 생성 
		new week12_3();
	}

}
