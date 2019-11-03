package mastermind.views.console;

import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

	void writeln(int blacks, int whites) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + blacks)
				.replaceFirst("#whites", "" + whites));
	}

}
