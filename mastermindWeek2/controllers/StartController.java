package mastermindWeek2.controllers;

import mastermindWeek2.models.Game;
import mastermindWeek2.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void start() {
        this.state.next();
    }

    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
