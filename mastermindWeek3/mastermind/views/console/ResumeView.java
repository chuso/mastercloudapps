package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.ResumeController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}
	
}
