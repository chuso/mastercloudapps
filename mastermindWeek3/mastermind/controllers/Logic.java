package mastermindWeek3.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.StateValue;

public abstract class Logic {

	protected Session session;
	protected Map<StateValue, AcceptorController> controllers;

	public Logic() {
		this.controllers = new HashMap<>();
	}

	public AcceptorController getController() {
		return this.controllers.get(this.session.getValueState());
	}

}
