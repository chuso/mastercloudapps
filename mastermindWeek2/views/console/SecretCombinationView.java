package mastermindWeek2.views.console;

import mastermindWeek2.controllers.Logic;
import mastermindWeek2.models.SecretCombination;

public class SecretCombinationView {

    private final Logic logic;

    public SecretCombinationView(Logic logic) {
        this.logic = logic;
    }

    public void writeln() {
      SecretCombination secretCombination = logic.getSecretCombination();
		  for (int i = 0; i < secretCombination.getSize(); i++) {
			  Message.SECRET.write();
		  }
		  Message.NEW_LINE.write();
    }

}
