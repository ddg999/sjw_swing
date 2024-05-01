package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame1 extends JFrame {

	private JLabel jplayer;

	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final int MOVE_DISTANCE = 50;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final String PLAYER_NAME = "강아지";
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;

	public MiniGame1() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jplayer = new JLabel(PLAYER_NAME);
		jplayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
	}

	private void setInitLayout() {
		setLayout(null); // 좌표기반으로 배치관리자 변경
		add(jplayer);
		jplayer.setLocation(jPlayerX, jPlayerY);
		setVisible(true);
	}

	private void addEventListener() {
		// jplayer 객체한테만 keyListener 동작을 시키고자 한다면
		// 익명 구현클래스로 KeyListener 인터페이스를 재정의 할 수 있다.
		// jplayer.addKeyListener(this);

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
//				int x = jplayer.getX();
//				int y = jplayer.getY();
//				if (e.getKeyCode() == KeyEvent.VK_UP) {
//					jplayer.setLocation(x, y - 10);
//				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//					jplayer.setLocation(x - 10, y);
//				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//					jplayer.setLocation(x + 10, y);
//				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//					jplayer.setLocation(x, y + 10);
//				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jPlayerY -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jPlayerX -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jPlayerX += MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					jPlayerY += MOVE_DISTANCE;
				}
				jplayer.setLocation(jPlayerX, jPlayerY);
			}
		});
	}

	// 코드 테스트
	public static void main(String[] args) {
		new MiniGame1();
	} // end of main
}
