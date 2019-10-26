package mastermindWeek3.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermindWeek3.mastermind.controllers.implementation.StartControllerImplementation;
import mastermindWeek3.mastermind.controllers.implementation.PlayControllerImplementation;
import mastermindWeek3.mastermind.controllers.implementation.ResumeControllerImplementation;
import mastermindWeek3.mastermind.distributed.StartControllerProxy;
import mastermindWeek3.mastermind.distributed.PlayControllerProxy;
import mastermindWeek3.mastermind.distributed.ResumeControllerProxy;
import mastermindWeek3.mastermind.distributed.SessionProxy;
import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.SessionImplementation;
import mastermindWeek3.mastermind.models.StateValue;

public class Logic {

	private Session session;
	protected Map<StateValue, AcceptorController> controllers;
	private TCPIP tcpip;

	public Logic(Boolean isStandalone) {
		if (isStandalone) {
			this.tcpip = null;
		} else {
			this.tcpip = TCPIP.createClientSocket();
		}
		this.session = isStandalone ? new SessionImplementation() : new SessionProxy(tcpip);
		this.controllers = new HashMap<StateValue, AcceptorController>();
		this.controllers.put(StateValue.INITIAL, isStandalone ? new StartControllerImplementation(this.session) : new StartControllerProxy(session, tcpip));
		this.controllers.put(StateValue.IN_GAME, isStandalone ? new PlayControllerImplementation(this.session) : new PlayControllerProxy(session, tcpip));
		this.controllers.put(StateValue.FINAL, isStandalone ? new ResumeControllerImplementation(this.session) : new ResumeControllerProxy(session, tcpip));
		this.controllers.put(StateValue.EXIT, null);
	}

	public AcceptorController getController() {
		return this.controllers.get(this.session.getValueState());
	}

	public void close() {
		this.tcpip.close();
	}
}
