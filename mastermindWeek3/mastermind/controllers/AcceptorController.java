package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Game;
import mastermindWeek3.mastermind.models.State;

public abstract class AcceptorController extends Controller {

	AcceptorController(Game game, State state) {
        super(game, state);
    }

	public abstract void accept(ControllersVisitor controllersVisitor);

}

