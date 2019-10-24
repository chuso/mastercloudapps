package mastermindWeek3.mastermind.views.console.menu;

import java.util.ArrayList;
import java.util.List;

import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.views.ColorView;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.Console;

class CombinationReader {

    private Console console;

    public CombinationReader() {
        this.console = new Console();
    }

    public List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
    }
}
