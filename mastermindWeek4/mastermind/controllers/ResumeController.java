package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.views.console.ResumeView;

public class ResumeController extends Controller {

	public ResumeController(Game game, State state) {
		super(game, state);
	}

	@Override
	public void control() {
		boolean resume = new ResumeView().resume();
		this.resume(resume);
	}
	
	private void resume(boolean newGame) {
		if (newGame) {
			this.game.clear();
			this.state.reset();
		} else {
			this.state.next();
		}
	}

}
