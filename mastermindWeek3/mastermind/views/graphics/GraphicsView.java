package mastermindWeek3.mastermind.views.graphics;

import mastermindWeek3.mastermind.controllers.ProposalController;
import mastermindWeek3.mastermind.controllers.ResumeController;
import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView() {
		this.gameView = new GameView();
	}

	@Override
	public void visit(StartController startController) {
		this.gameView.interact(startController);
	}

	@Override
	public void visit(ProposalController proposalController) {
		this.gameView.interact(proposalController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		ResumeDialog resumeDialog = new ResumeDialog();
		resumeController.resume(resumeDialog.isNewGame());
		if (resumeDialog.isNewGame()) {
			this.gameView = new GameView();
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
		}
	}

}
