package mastermindWeek3.mastermind;

import mastermindWeek3.mastermind.views.View;
import mastermindWeek3.mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind{

	protected View createView() {
		return new ConsoleView();
	}

	protected Boolean isStandalone() {
		return true;
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
}
