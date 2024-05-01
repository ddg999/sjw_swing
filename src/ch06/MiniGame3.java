package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame3 extends JFrame {

	private JLabel jplayer;

	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final int MOVE_DISTANCE = 50;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final String PLAYER_NAME = "야스오";
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;

	public MiniGame3() {
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
		setLayout(null);
		add(jplayer);
		jplayer.setLocation(jPlayerX, jPlayerY);
		setVisible(true);
	}

	private void addEventListener() {

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
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
		new MiniGame3();
	} // end of main
}
