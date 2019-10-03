package mastermindWeek2;

import mastermindWeek2.models.Game;

public class Mastermind  {

    private Game game;

	private Mastermind() {
		this.game = new Game();
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

	private void play() {
        game.play();
	}

}
