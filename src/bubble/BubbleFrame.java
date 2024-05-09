package bubble;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import bubble.components.Enemy;
import bubble.components.Player;

public class BubbleFrame extends JFrame {
	// 컨텍스트를 생성하는 방법 (셀프 참조)
	BubbleFrame mContext = this;

	private JLabel backgroundMap;
	// 포함관계 - 콤포지션
	private Player player;
	private Enemy enemy;

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		// todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		// backgroundMap = new JLabel(new ImageIcon("img/backgroundMapService.png"));
		// backgroundMap = new JLabel(new ImageIcon("img/test.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap); // Frame -> root Panel에 add 처리
		setSize(1000, 640);

		// mContext --> 참조 타입() --> 주소값의 크기는 기본 4byte 이다.
		player = new Player(mContext);
		enemy = new Enemy(mContext);
	}

	private void setInitLayout() {
		setLayout(null); // 좌표 값으로 배치
		setResizable(false); // 프레임 조절 불가
		setLocationRelativeTo(null); // JFrame을 모니터 가운데 자동 배치
		setVisible(true);
		add(player);
		add(enemy);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					player.up();
					break;
				case KeyEvent.VK_SPACE:
					player.attack();
					// 프레임에 컴포넌트를 add 동작은 누구? JFrame --> add() 메서드이다.
					// 버블 실행시에 끊김 현상이 발생하는 이유는 왜 일까?
					break;
				default:
					break;
				}
			} // end of KeyPressed

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가는 상태 멈춤
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가는 상태 멈춤
					player.setRight(false);
					break;
				default:
					break;
				}
			} // end of KeyReleased
		});
	}

	public Player getPlayer() {
		return player;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	// 코드 테스트
	public static void main(String[] args) {
		try {
			Thread.sleep(3000);
			new BubbleFrame();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// main 함수를 가지고 있는 클래스는 하위에 생성된 모든 객체들의
		// 주소값을 알고 있다. (중요! 중요! 중요!)
	} // end of main
}
