package mastermindWeek3.mastermind.controllers.implementation;

import mastermindWeek3.mastermind.controllers.Logic;
import mastermindWeek3.mastermind.models.SessionImplementation;
import mastermindWeek3.mastermind.models.StateValue;

public class LogicImplementation extends Logic {

	public LogicImplementation() {
        super();
		this.session = new SessionImplementation();
		this.controllers.put(StateValue.INITIAL, new StartControllerImplementation(this.session));
		this.controllers.put(StateValue.IN_GAME, new PlayControllerImplementation(this.session));
		this.controllers.put(StateValue.SAVING, new SaveControllerImplementation(this.session));
		this.controllers.put(StateValue.FINAL, new ResumeControllerImplementation(this.session));
		this.controllers.put(StateValue.EXIT, null);
	}

}
