package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.Controller;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {
	
	private Controller controller;
	
	SecretCombinationView(Controller controller) {
		super();
		this.controller = controller;
	}
	
	void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
