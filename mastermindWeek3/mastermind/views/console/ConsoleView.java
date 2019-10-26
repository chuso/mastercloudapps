package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.*;
import mastermindWeek3.mastermind.views.View;
import mastermindWeek3.mastermind.views.console.menu.PlayMenu;

public class ConsoleView extends View {

	private StartView startView;

	private ResumeView resumeView;

	public ConsoleView() {
		this.startView = new StartView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(PlayController playController) {
		new PlayMenu(playController).execute();
		new ProposalView(playController).writeln();
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

	@Override
	public void visit(SaveController saveController) {
		new SaveView(saveController).interact();
	}

}
