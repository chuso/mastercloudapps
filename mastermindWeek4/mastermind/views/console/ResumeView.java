package mastermind.views.console;

import mastermind.controllers.ResumeController;
import mastermind.views.MessageView;
import santaTecla.utils.YesNoDialog;

public class ResumeView {

	public boolean resume() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}
	
}
