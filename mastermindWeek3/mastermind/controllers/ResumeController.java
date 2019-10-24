package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Game;
import mastermindWeek3.mastermind.models.State;

public class ResumeController extends Controller {

	public ResumeController(Game game, State state) {
		super(game, state);
	}
	
	public void resume(boolean newGame) {
		if (newGame) {
			this.game.clear();
			this.state.reset();
		} else {
			this.state.next();
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
