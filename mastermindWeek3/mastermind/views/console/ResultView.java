package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
	
	private PlayController playController;
	
	ResultView(PlayController proposalController){
		this.playController = proposalController;
	}

	void writeln(int i) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.playController.getBlacks(i))
				.replaceFirst("#whites", "" + this.playController.getWhites(i)));
	}

}
