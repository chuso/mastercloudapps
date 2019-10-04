package mastermindWeek2.controllers;

import mastermindWeek2.models.Game;
import mastermindWeek2.models.State;

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

    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
