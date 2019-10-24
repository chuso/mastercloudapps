package mastermindWeek3.mastermind.views;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {
	
	public void interact(AcceptorController controller) {
		controller.accept(this);
	}

}
