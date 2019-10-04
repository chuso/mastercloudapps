package mastermindWeek2.controllers;

import mastermindWeek2.models.Game;
import mastermindWeek2.models.SecretCombination;

public abstract class Controller {

    final Game game;

    Controller(Game game) {
        this.game = game;
    }

    public SecretCombination getSecretCombination() {
        return game.getSecretCombination();
    }

}
