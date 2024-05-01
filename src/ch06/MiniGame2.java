package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame2 extends JFrame {

	private JLabel backgroundMap;
	private JLabel jplayer;

	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final int MOVE_DISTANCE = 50;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;

	public MiniGame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Icon icon = new ImageIcon("images/background1.jpg");
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(500, 500);
		backgroundMap.setLocation(0, 0);

		jplayer = new JLabel(new ImageIcon("images/image4.png"));
		jplayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		jplayer.setLocation(jPlayerX, jPlayerY);

	}

	private void setInitLayout() {
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(jplayer);
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

	public static void main(String[] args) {
		new MiniGame2();
	}
}
