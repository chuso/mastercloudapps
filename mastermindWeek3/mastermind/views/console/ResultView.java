package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.ProposalController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
	
	private ProposalController proposalController;
	
	ResultView(ProposalController proposalController){
		this.proposalController = proposalController;
	}

	void writeln(int i) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.proposalController.getBlacks(i))
				.replaceFirst("#whites", "" + this.proposalController.getWhites(i)));
	}

}
