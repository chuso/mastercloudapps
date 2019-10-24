package mastermindWeek3.mastermind.views;

import mastermindWeek3.mastermind.controllers.Controller;
import mastermindWeek3.mastermind.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {
	
	public void interact(Controller controller) {
		controller.accept(this);
	}

}
