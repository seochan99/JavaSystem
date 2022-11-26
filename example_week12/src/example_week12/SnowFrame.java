package example_week12;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
public
class SnowFrame extends JFrame {
	
public SnowFrame() {
    super("눈 내리는 샤갈의 마을");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(new SnowPanel());
    setSize(300, 300);
    setResizable(false);
    setVisible(true);
  }

  class SnowPanel extends JPanel {
  private ImageIcon icon = new ImageIcon("images/Koala.png");
  private Image img = icon.getImage();
  private final int SNOWS =130;
  private final int SNOW_SIZE = 10;
  private Vector<Point> snowVector = new Vector<Point>(); // 눈 송이의 왼쪽 좌표 Point
  
  public SnowPanel() {
      this.addComponentListener(new ComponentAdapter() {
        @Override
            // 패널의 위치와 크기가 설정되면 그 때 비로소 눈을 만든다.
        public void componentResized(ComponentEvent e) {
        	//눈을 만들고
        	addSnow();
        	// 눈 내리는 스레드를 시작시킨다.
        	new SnowThread().start();
        	// 현재 패널에 적합하도록 눈을 만들면 리스너를 제거한다.
        	SnowPanel.this.removeComponentListener(this);
        	}
      });
    }
  
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),
                  this); // 배경 이미지를 그린다.
      drawSnow(g);       // 눈을 그린다.
    }
  private void addSnow() { // 각 눈의 위치를 랜덤하게 생성하여 벡터에 삽입한다.
      for (int i = 0; i < SNOWS; i++) {
        Point p = new Point((int)(Math.random() * getWidth()),
                            (int)(Math.random() * getHeight()));
        snowVector.add(p);
      }
    }
  private
    void drawSnow(Graphics g) { // 패널에 눈을 그린다.
      g.setColor(Color.WHITE);
      for (int i = 0; i < snowVector.size(); i++) {
        Point p = snowVector.get(i);
        g.fillOval(p.x, p.y, SNOW_SIZE, SNOW_SIZE);
      }
    }
  private
    void changeSnowPosition() { // 눈의 위치를 조정한다.
      for (int i = 0; i < SNOWS; i++) {
        Point p = snowVector.get(i);
        // xDir이 1이면 오른쪽으로, 아니면 왼쪽으로 눈을 이동시킨다.
        int xDir = Math.random() > 0.5 ? 1 : -1;
        int offsetX = (int)(Math.random() * 3) *
                      xDir; // x 축으로 이동하는 최대 거리는 3 픽셀이다.
        int offsetY = (int)(Math.random() *
                            7); // y 축으로 이동하는 최대 거리는 7 픽셀이다.
        p.x += offsetX;
        if (p.x < 0)
          p.x = 0;
        p.y += offsetY;
        // 눈이 떨어져서 패널을 벗어나게 되면 다시 패널의 위에서 시작하게 한다.
        if (p.y > getHeight()) {
          // 다시 시작하는 x 위치는 패널 내의 랜덤한 위치
          p.x = (int)(Math.random() * getWidth());
          p.y = 5; // 다시 시작하는 y 위치는 패널 내의 5 픽셀 위치
        }
      }
    }
    class SnowThread extends Thread {
      @Override public void run() {
        while (true) {
          try {
            sleep(300); // 0.3초마다 눈이 내린다.
          } catch (InterruptedException e) {
            return;
          }
          changeSnowPosition(); // 눈의 위치를 재조정한다.
          SnowPanel.this
              .repaint(); // 조정된 위치에 눈이 그려지도록 패널을 다시 그린다.
        }
      }
    }
  } static public void main(String[] args) {
    new SnowFrame();
  }
}