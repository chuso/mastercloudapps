package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class StartView extends WithConsoleView {

	public void print(int combinationWidth) {
		this.console.writeln(MessageView.TITLE.getMessage());
		new SecretCombinationView().writeln(combinationWidth);
	}

}
