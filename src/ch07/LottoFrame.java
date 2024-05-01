package ch07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LottoFrame extends JFrame implements ActionListener {

	private JButton button;
	private LottoRandomNumber lottoRandomNumber;
	private boolean isStart = true;
	private int NUMBER_DISTANCE = 80;

	private Image image1;

	public LottoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Lotto Game");
		setSize(600, 400);
		setBackground(Color.yellow);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Game Start");
		lottoRandomNumber = new LottoRandomNumber();
		image1 = new ImageIcon("image2.png").getImage();

	}

	private void setInitLayout() {
		add(button, BorderLayout.NORTH);
		button.setBackground(Color.green);

		setVisible(true);
	}

	private void addEventListener() {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트가 일어나면 그림을 다시 그려라
		// System.out.println("그림을 그려라");

		isStart = false;
		repaint(); // 다시 그림을 그려라 // F5
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Font f = new Font("휴먼모음T", Font.PLAIN, 20);
		g.setFont(f);

		if (isStart) {
			g.drawString("로또 번호를 클릭하세요", 200, 200);
		} else {
			int[] getNumbers = lottoRandomNumber.createNumber();
			for (int i = 0; i < getNumbers.length; i++) {
				g.drawString(getNumbers[i] + " ", 85 + (i * NUMBER_DISTANCE), 180);
				g.drawImage(lottoRandomNumber.createNumber2(), 55 + (i * NUMBER_DISTANCE), 137, 70, 70, null);
				g.drawImage(image1, 60 + (i * NUMBER_DISTANCE), 200, 70, 70, null);
			}
		}
	}

	public static void main(String[] args) {
		new LottoFrame();
	}
}
