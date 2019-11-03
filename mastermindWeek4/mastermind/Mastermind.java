package mastermind;

import mastermind.controllers.Controller;
import mastermind.controllers.Logic;
import mastermind.views.Factory;

public abstract class Mastermind {
	
	private Logic logic;
	
	protected Mastermind() {
		this.logic = new Logic(this.buildViewFactory());
	}

	protected abstract Factory buildViewFactory();

	protected void play() {
		Controller controller;
		do {
			controller = this.logic.getController();
			if (controller != null){
				controller.control();
			}
		} while (controller != null); 
	}
	
}

