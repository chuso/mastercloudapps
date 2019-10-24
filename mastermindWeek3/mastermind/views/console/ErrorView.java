package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.types.Error;
import mastermindWeek3.santaTecla.utils.Console;

class ErrorView extends mastermindWeek3.mastermind.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
