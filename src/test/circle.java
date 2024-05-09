package test;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class circle extends JPanel {

	Image image;
	private int x;
	private int y;
	private int width;
	private int height;

	public circle() {
		initData();
		setInitLayout();
	}

	public void initData() {
		image = new ImageIcon("images/noteSample.png").getImage();

		x = 150;
		y = 150;
		width = 150;
		height = 150;
		new Thread(new NoteService(this)).start();
	}

	public void setInitLayout() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		while (true) {
//		g.drawImage(image, x, y, 50, 50, null);
		g.drawOval(x, y, width, height);
		width--;
		height--;
		repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		}
	}
}
