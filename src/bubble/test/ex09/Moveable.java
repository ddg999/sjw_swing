package bubble.test.ex09;

public interface Moveable {

	void left();
	void right();
	void up();
	// 인터페이스 추가 기능 default 사용해보기
	// 인터페이스의 모든 메서드는 추상 메서드이어야 한다.
	// 단, default 메서드는 제외
	default void down() {
	}; // 마지막에 ; 붙이기
}
