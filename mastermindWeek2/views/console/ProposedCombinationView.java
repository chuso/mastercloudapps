package mastermindWeek2.views.console;

import mastermindWeek2.controllers.ProposeController;
import mastermindWeek2.models.ProposedCombination;
import mastermindWeek2.models.Color;

public class ProposedCombinationView {

    private final ProposeController proposeController;
    private final int index;

    public ProposedCombinationView(ProposeController proposeController, int index) {
        this.proposeController = proposeController;
        this.index = index;
    }

    public void write() {
      ProposedCombination proposedCombination = proposeController.getProposedCombination(index);
		  for (Color color : proposedCombination.getColors()) {
        new ColorView(color).write();
		  }
    }

}
