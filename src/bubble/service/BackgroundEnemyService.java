package bubble.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bubble.components.Enemy;

public class BackgroundEnemyService implements Runnable {

	private BufferedImage image;
	private Enemy enemy;

	// 생성자 의존 주입 DI
	public BackgroundEnemyService(Enemy enemy) {
		this.enemy = enemy;
		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인 todo (보정값 필요)
			Color leftColor = new Color(image.getRGB(enemy.getX() + 5, enemy.getY() + 25));
			Color rightColor = new Color(image.getRGB(enemy.getX() + 60, enemy.getY() + 25));

			// Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));
			// 흰색이면 바닥 RGB => 255 255 255
			// 빨간바닥인 경우 RGB => 255 0 0
			// 파란바닥인 경우 RGB => 0 0 255
			int bottomColorLeft = image.getRGB(enemy.getX() + 20, enemy.getY() + 55);
			int bottomColorRight = image.getRGB(enemy.getX() + 40, enemy.getY() + 55);

			// 하얀색 --> int값이 -1
			if (bottomColorLeft + bottomColorRight != -2) {
				// 여기는 멈춰야 한다. ( 빨간 바닥 또는 파란색 바닥 )
				enemy.setDown(false);
			} else if (!enemy.isUp() && !enemy.isDown()) {
				enemy.down();
			}
//			if (!player.isUp() && bottomColorLeft + bottomColorRight == -2) {
//				player.down();
//			}

			// 왼쪽 벽에 충돌함
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함");
				enemy.setLeftWallCrash(true);
				enemy.setLeft(false);
				enemy.right();
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함");
				enemy.setRightWallCrash(true);
				enemy.setRight(false);
				enemy.left();
			} else {
				enemy.setLeftWallCrash(false);
				enemy.setRightWallCrash(false);
			}

			// 위 두 조건이 아니면 player 마음대로 움직일 수 있다.
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
