package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing -> 배치 관리자 : FlowLayout
// 컴포넌트(버튼, 라벨 등)들을 수평, 수직으로 배치해주는 클래스
public class FlowLayoutEx2 extends JFrame {

	// 배열 활용

	private JButton[] buttons;

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로세스도 종료시킴

		// 생성자에서 메서드 호출 가능하다
		initData();
		setInitLayout();
	}

	// 멤버 변수를 초기화하는 기능(값을 넣다)
	public void initData() {
		buttons = new JButton[6]; // 공간만 선언 [][][][][][]
		
		// 반복문 활용
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(i + 1 + "번");
		}
	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		// 배치 관리자 --> BorderLayout 이라는 배치관리자가 기본으로 활용된다
		// FlowLayout flowLayout = new FlowLayout();
		// super.setLayout(flowLayout); // 배치관리자 --> FlowLayout

		// 배치관리자 생성 및 JFrame 셋팅
		// FlowLayout (정렬, 가로 갭, 세로 갭)
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50));

		// 컴포넌트들을 붙이다
		// 반복문 활용
		for (int i = 0; i < buttons.length; i++) {
			super.add(buttons[i]);
		}
	}

	// 코드 테스트
	public static void main(String[] args) {
		// FlowLayoutEx f1 = new FlowLayoutEx(); <--- 부를 수 있는 이름이 있는 상태
		new FlowLayoutEx2(); // <--- 익명 클래스 : 다시 접근해서 사용할 일 없으면...

	} // end of main

}
