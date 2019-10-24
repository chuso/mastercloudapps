package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Session;

public abstract class AcceptorController extends Controller {

	AcceptorController(Session session) {
        super(session);
    }

	public abstract void accept(ControllersVisitor controllersVisitor);

}

