package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.distributed.TCPIP;
import mastermindWeek3.mastermind.models.Session;

public class StartController extends AcceptorController {

	public StartController(Session session, TCPIP tcpip) {
		super(session, tcpip);
	}

	public void start() {
		this.session.next();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
