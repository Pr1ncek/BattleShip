
public class Game {

	private State state;

	public static boolean gameOver = false;

	private Game() {

		this.state = new PlayingState();

	}

	public void nextState() {
		state.nextMove(this);
	}

	public void setState(State state) {

		this.state = state;

	}

	public State getState() {
		return state;
	}

	public static void main(String[] args) {

		Game game = new Game();

		//while (!gameOver)
			game.nextState();

	}

}
