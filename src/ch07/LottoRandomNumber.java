package ch07;

import java.awt.Image;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;

// 클래스를 --> 단일 책임 원칙을 설정하는 것이 좋다

public class LottoRandomNumber {

	public Image image;

	final int LOTTO_NUMBER_COUNT = 6;

	public Image createNumber2() {
		image = new ImageIcon("images/circle.png").getImage();

		return image;
	}

	public int[] createNumber() {
		int[] lottoWinNum = new int[LOTTO_NUMBER_COUNT];

		Random random = new Random();

		for (int i = 0; i < lottoWinNum.length; i++) {
			lottoWinNum[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lottoWinNum[i] == lottoWinNum[j]) {
					i--;
				}
			}
		}
		// 중복 제거 완료
		Arrays.sort(lottoWinNum); // 오름차순으로 자동 정렬

		return lottoWinNum;
	}

	public static void main(String[] args) {
		LottoRandomNumber randomNumber = new LottoRandomNumber();
		int[] resultArray = randomNumber.createNumber();

		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
	}
}
