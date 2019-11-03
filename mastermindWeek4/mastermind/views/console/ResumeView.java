package mastermind.views.console;

import mastermind.controllers.ResumeController;
import mastermind.views.MessageView;
import santaTecla.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		boolean resume = this.resume();
		resumeController.resume(resume);
	}

	public boolean resume() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}
	
}
