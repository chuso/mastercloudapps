package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.santaTecla.utils.Console;

class ColorView extends mastermindWeek3.mastermind.views.ColorView {

	ColorView(Color color) {
		super(color);
	}
	
	void write() {
		new Console().write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
