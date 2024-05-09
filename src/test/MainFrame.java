package test;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	circle note;

	public MainFrame() {
		initData();
		setInitLayout();
	}

	public void initData() {
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		note = new circle();
	}

	public void setInitLayout() {
		setVisible(true);
		add(note);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
