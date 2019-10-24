package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.views.console.ColorView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {
	
	private PlayController playController;
	
	public ProposedCombinationView(PlayController playController) {
		this.playController = playController;
	}
	
	void write(int position) {
		for (Color color : this.playController.getColors(position)) {
			new ColorView(color).write();
		}
	}
	
}
