package mastermindWeek2.controllers;

import mastermindWeek2.models.Game;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public void resume() {
        this.game.clear();
    }

}
