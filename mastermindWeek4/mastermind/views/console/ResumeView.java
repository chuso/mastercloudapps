package mastermind.views.console;

import mastermind.views.MessageView;
import santaTecla.utils.YesNoDialog;

public class ResumeView implements mastermind.views.ResumeView {

	@Override
	public boolean resume() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}
	
}
