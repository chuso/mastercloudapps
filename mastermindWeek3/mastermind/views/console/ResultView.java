package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
	
	private AcceptorController acceptorController;
	
	ResultView(AcceptorController proposalController){
		this.acceptorController = proposalController;
	}

	void writeln(int i) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.acceptorController.getBlacks(i))
				.replaceFirst("#whites", "" + this.acceptorController.getWhites(i)));
	}

}
