package mastermindWeek3.mastermind;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.Logic;
import mastermindWeek3.mastermind.views.View;

public abstract class Mastermind {

	private Logic logic;

	private View view;

	protected Mastermind() {
		this.logic = new Logic(this.isStandalone());
		this.view = this.createView();
	}

	protected abstract View createView();

	protected abstract Boolean isStandalone();

	protected void play() {
		AcceptorController controller;
		do {
			controller = this.logic.getController();
			if (controller != null) {
				this.view.interact(controller);
			}
		} while (controller != null);
		if (!this.isStandalone()) {
			this.logic.close();
		}
	}

}
