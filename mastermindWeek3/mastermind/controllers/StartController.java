package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;

public class StartController extends AcceptorController {

	public StartController(Session session, TCPIP tcpip) {
		super(session, tcpip);
	}

	public void start() {
		if (this.tcpip == null) {
			this.session.next();
		} else {
			this.tcpip.send(FrameType.START.name());
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
