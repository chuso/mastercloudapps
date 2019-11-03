package mastermind.views.console;

import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class StartView extends WithConsoleView implements mastermind.views.StartView {

	@Override
	public void print(int combinationWidth) {
		this.console.writeln(MessageView.TITLE.getMessage());
		new SecretCombinationView().writeln(combinationWidth);
	}

}
