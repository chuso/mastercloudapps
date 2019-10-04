package mastermindWeek2;

import mastermindWeek2.models.Game;
import mastermindWeek2.views.View;
import mastermindWeek2.views.console.ConsoleView;

public class Mastermind  {

	private View view;
    private Game game;

	private Mastermind() {
		this.game = new Game();
		this.view = new ConsoleView(this.game);
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

	private void play() {
        view.interact();
	}

}
