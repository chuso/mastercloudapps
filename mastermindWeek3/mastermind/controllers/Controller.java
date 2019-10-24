package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Session;

public abstract class Controller {

	protected Session session;

	Controller(Session session) {
		this.session = session;
	}
	
	public int getWidth() {
		return this.session.getWidth();
	}

}
