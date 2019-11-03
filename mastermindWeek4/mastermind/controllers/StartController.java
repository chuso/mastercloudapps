package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.views.StartView;

public class StartController extends Controller {

	private StartView startView;

	public StartController(StartView startView, Game game, State state) {
		super(game, state);
		this.startView = startView;
	}

	@Override
	public void control() {
		this.state.next();
		startView.print(this.game.getWidth());
	}

}
