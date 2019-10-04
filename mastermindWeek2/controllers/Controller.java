package mastermindWeek2.controllers;

import mastermindWeek2.models.Game;
import mastermindWeek2.models.SecretCombination;
import mastermindWeek2.models.State;


public abstract class Controller {

    final Game game;

    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public SecretCombination getSecretCombination() {
        return game.getSecretCombination();
    }

}
