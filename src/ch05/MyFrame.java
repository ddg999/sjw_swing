package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {

	private static final LayoutManager FlowLayout = null;
	private JPanel panel1;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;

	public MyFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel1 = new JPanel();
		panel2 = new JPanel();
		button1 = new JButton("검정");
		button2 = new JButton("파랑");
		button3 = new JButton("노랑");
		button4 = new JButton("초록");
		button5 = new JButton("빨강");
		button6 = new JButton("하늘");
	}

	private void setInitLayout() {
		add(panel1);
		add(panel2, BorderLayout.SOUTH);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);

		setVisible(true);
	}

	// 이 메서드의 책임은 이벤트 리스너만 등록
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
	}

	// 오버라이드 : 이벤트가 일어나면 호출되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button1)) {
			panel1.setBackground(Color.BLACK);
		} else if (e.getSource().equals(button2)) {
			panel1.setBackground(Color.BLUE);
		} else if (e.getSource().equals(button3)) {
			panel1.setBackground(Color.YELLOW);
		} else if (e.getSource().equals(button4)) {
			panel1.setBackground(Color.GREEN);
		} else if (e.getSource().equals(button5)) {
			panel1.setBackground(Color.RED);
		} else if (e.getSource().equals(button6)) {
			panel1.setBackground(Color.CYAN);
		}

	}

	public static void main(String[] args) {
		new MyFrame();
	} // end of main

}
