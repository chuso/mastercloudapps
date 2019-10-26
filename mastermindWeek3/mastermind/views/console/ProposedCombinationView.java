package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.views.console.ColorView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {
	
	private AcceptorController acceptorController;
	
	public ProposedCombinationView(AcceptorController playController) {
		this.acceptorController = playController;
	}
	
	void write(int position) {
		for (Color color : this.acceptorController.getColors(position)) {
			new ColorView(color).write();
		}
	}
	
}
