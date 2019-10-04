package mastermindWeek2.views.console;

import mastermindWeek2.models.ProposedCombination;
import mastermindWeek2.models.Color;

public class ProposedCombinationView {

    private final ProposedCombination proposedCombination;

    public ProposedCombinationView(ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
    }

    public void write() {
		for (Color color : proposedCombination.getColors()) {
            new ColorView(color).write();
		}
    }

}
