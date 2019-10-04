package mastermindWeek2.views.console;

import mastermindWeek2.controllers.Controller;
import mastermindWeek2.models.SecretCombination;

public class SecretCombinationView {

    private final Controller startController;

    public SecretCombinationView(Controller startController) {
        this.startController = startController;
    }

    public void writeln() {
      SecretCombination secretCombination = startController.getSecretCombination();
		  for (int i = 0; i < secretCombination.getSize(); i++) {
			  Message.SECRET.write();
		  }
		  Message.NEW_LINE.write();
    }

}
