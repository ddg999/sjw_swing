package bubble.test.ex01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private ImageIcon playerR, playerL;
	private int x;
	private int y;

	public Player() {
		initData();
		setInitLayout();
	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 처음 실행시 초기값 셋팅
		x = 60;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		if (x <= 60) {
			setIcon(playerL);
			return;
		} else {
			setIcon(playerL);
			x -= 10;
			setLocation(x, y);
		}
	}

	@Override
	public void right() {
		if (x >= 880) {
			setIcon(playerR);
			return;
		} else {
			setIcon(playerR);
			x += 10;
			setLocation(x, y);
		}
	}

	@Override
	public void up() {
		System.out.println("점프");
		if (y == 178) {
			y = 535;
			setLocation(x, y);
		} else {
			y -= 119;
			setLocation(x, y);
		}
	}

	@Override
	public void down() {
		System.out.println("다운");
	}

}
