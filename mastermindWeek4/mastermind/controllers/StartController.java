package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class StartController extends Controller {

	public StartController(Game game, State state) {
		super(game, state);
	}
	
	public void start() {
		this.state.next();
	}

	public int getWidth() {
		return this.game.getWidth();
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
