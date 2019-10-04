package mastermindWeek2.views.console;

import mastermindWeek2.controllers.Controller;
import mastermindWeek2.models.SecretCombination;

public class SecretCombinationView {

    private final Controller controller;

    public SecretCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void writeln() {
      SecretCombination secretCombination = controller.getSecretCombination();
		  for (int i = 0; i < secretCombination.getSize(); i++) {
			  Message.SECRET.write();
		  }
		  Message.NEW_LINE.write();
    }

}
