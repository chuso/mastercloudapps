package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.views.console.StartView;

public class StartController extends Controller {

	public StartController(Game game, State state) {
		super(game, state);
	}

	@Override
	public void control() {
		this.state.next();
		new StartView().print(this.game.getWidth());
	}

}
