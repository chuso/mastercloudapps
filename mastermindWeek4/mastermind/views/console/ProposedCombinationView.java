package mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import mastermind.controllers.ProposalController;
import mastermind.types.Color;
import mastermind.views.console.ColorView;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

class ProposedCombinationView extends WithConsoleView {
	
	void write(List<Color> colors) {
		for (Color color : colors) {
			new ColorView(color).write();
		}
	}

	List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
