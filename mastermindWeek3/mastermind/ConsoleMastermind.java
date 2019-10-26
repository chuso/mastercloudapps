package mastermindWeek3.mastermind;

import mastermindWeek3.mastermind.controllers.Logic;
import mastermindWeek3.mastermind.controllers.implementation.LogicImplementation;
import mastermindWeek3.mastermind.views.View;
import mastermindWeek3.mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind{

	@Override
	protected View createView() {
		return new ConsoleView();
	}

	@Override
	protected Logic createLogic() {
		return new LogicImplementation();
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
}
