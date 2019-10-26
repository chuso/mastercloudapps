package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;

public class ResumeController extends AcceptorController {

	public ResumeController(Session session, TCPIP tcpip) {
		super(session, tcpip);
	}

	public void resume(boolean newGame) {
		if (this.tcpip == null) {
			if (newGame) {
				this.session.resume();
			} else {
				this.session.next();
			}
		} else {
			this.tcpip.send(FrameType.NEW_GAME.name());
			this.tcpip.send(newGame);
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
