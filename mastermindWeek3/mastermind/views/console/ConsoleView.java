package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.ProposalController;
import mastermindWeek3.mastermind.controllers.ResumeController;
import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.views.View;

public class ConsoleView extends View {
	
	private StartView startView;
	
	private ProposalView proposalView;
	
	private ResumeView resumeView;
	
	public ConsoleView(){
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}

	@Override
	public void visit(ProposalController proposalController) {
		this.proposalView.interact(proposalController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

}
