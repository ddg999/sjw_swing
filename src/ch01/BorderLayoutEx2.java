package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 단축키 습관 ctrl+shift+o : 안쓰는 임포트,변수 삭제
public class BorderLayoutEx2 extends JFrame {

	final int WIDTH = 600;
	final int HEIGHT = 600;

	JButton[] buttons;
	String[] direction = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH,
			BorderLayout.CENTER };

	public BorderLayoutEx2() {
		initData();
		setInitLayout();

	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[direction.length];

	}

	public void setInitLayout() {
		// 배치 관리자 선정 (컨테이너)
		// BorderLayout -- 컴포넌트들을 동서남북가운데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		for (int i = 0; i < buttons.length; i++) {
			add(new JButton(direction[i]), direction[i]);
		}
	}

	public static void main(String[] args) {
		new BorderLayoutEx2();
	}
}
