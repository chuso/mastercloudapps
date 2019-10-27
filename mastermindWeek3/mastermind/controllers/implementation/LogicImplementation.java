package mastermindWeek3.mastermind.controllers.implementation;

import mastermindWeek3.mastermind.controllers.Logic;
import mastermindWeek3.mastermind.models.SessionImplementation;
import mastermindWeek3.mastermind.models.StateValue;
import mastermindWeek3.mastermind.models.DAO.SessionImplementationDAO;

public class LogicImplementation extends Logic {

	public LogicImplementation() {
        super();
		this.session = new SessionImplementation();
		SessionImplementationDAO sessionImplementationDAO = new SessionImplementationDAO((SessionImplementation) this.session);
		this.controllers.put(StateValue.INITIAL, new StartControllerImplementation(this.session, sessionImplementationDAO));
		this.controllers.put(StateValue.IN_GAME, new PlayControllerImplementation(this.session));
		this.controllers.put(StateValue.SAVING, new SaveControllerImplementation(this.session, sessionImplementationDAO));
		this.controllers.put(StateValue.FINAL, new ResumeControllerImplementation(this.session));
		this.controllers.put(StateValue.EXIT, null);
	}

}
