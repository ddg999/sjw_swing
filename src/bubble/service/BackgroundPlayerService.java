package bubble.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bubble.components.Player;

/**
 *  현재 메인 스레드는 너~무 바쁨
 *  백그라운드에서 계속 Player의 움직임을 관찰할 예정
 */
public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;

	// 생성자 의존 주입 DI
	public BackgroundPlayerService(Player player) {
		this.player = player;
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
			Color leftColor = new Color(image.getRGB(player.getX() + 5, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 60, player.getY() + 25));

			// Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));
			// 흰색이면 바닥 RGB => 255 255 255
			// 빨간바닥인 경우 RGB => 255 0 0
			// 파란바닥인 경우 RGB => 0 0 255
			int bottomColorLeft = image.getRGB(player.getX() + 20, player.getY() + 55);
			int bottomColorRight = image.getRGB(player.getX() + 40, player.getY() + 55);

			// 하얀색 --> int값이 -1
			if (bottomColorLeft + bottomColorRight != -2) {
				// 여기는 멈춰야 한다. ( 빨간 바닥 또는 파란색 바닥 )
				player.setDown(false);
			} else if (!player.isUp() && !player.isDown()) {
				player.down();
			}
//			if (!player.isUp() && bottomColorLeft + bottomColorRight == -2) {
//				player.down();
//			}

			// 왼쪽 벽에 충돌함
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
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
