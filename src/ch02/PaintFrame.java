package ch02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 내부 클래스 활용해서 코드를 완성해주세요
public class PaintFrame extends JFrame {

	PaintPanel paintPanel;

	public PaintFrame() {
		initData();
		setInitLayout();

	}

	public void initData() {
		setTitle("그림그리기");
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.DARK_GRAY);

		paintPanel = new PaintPanel();
	}

	public void setInitLayout() {
		add(paintPanel);
		setVisible(true);

	}

	class PaintPanel extends JPanel {

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(100, 500, 400, 400);
			g.drawLine(50, 500, 300, 300);
			g.drawLine(300, 300, 550, 500);
			g.drawLine(50, 500, 550, 500);
			g.drawRect(150, 550, 100, 100);
			g.drawLine(200, 550, 200, 650);
			g.drawLine(150, 600, 250, 600);
			g.setColor(Color.ORANGE);
			g.fillRect(350, 750, 80, 150);
			g.setColor(Color.RED);
			g.fillOval(410, 840, 10, 10);
			g.fillOval(550, 50, 150, 150);
			g.setColor(Color.BLUE);
			g.drawString("태양", 610, 130);
		}

	}

}
