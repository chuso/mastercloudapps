package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.views.ResumeView;

public class ResumeController extends Controller {

	private ResumeView resumeView;

	public ResumeController(ResumeView resumeView, Game game, State state) {
		super(game, state);
		this.resumeView = resumeView;
	}

	@Override
	public void control() {
		boolean resume = resumeView.resume();
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
