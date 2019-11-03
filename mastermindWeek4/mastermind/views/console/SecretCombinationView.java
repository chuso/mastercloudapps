package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {
	
	SecretCombinationView() {
		super();
	}
	
	void writeln(int combinationWidth) {
		for (int i = 0; i < combinationWidth; i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
