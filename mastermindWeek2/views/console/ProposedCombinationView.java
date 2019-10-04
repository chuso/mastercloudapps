package mastermindWeek2.views.console;

import mastermindWeek2.controllers.Logic;
import mastermindWeek2.models.ProposedCombination;
import mastermindWeek2.models.Color;

public class ProposedCombinationView {

    private final Logic logic;
    private final int index;

    public ProposedCombinationView(Logic logic, int index) {
        this.logic = logic;
        this.index = index;
    }

    public void write() {
      ProposedCombination proposedCombination = logic.getProposedCombination(index);
		  for (Color color : proposedCombination.getColors()) {
        new ColorView(color).write();
		  }
    }

}
