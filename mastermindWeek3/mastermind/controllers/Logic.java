package mastermindWeek3.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.Session;
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
		this.session = new Session(this.tcpip);
		this.controllers = new HashMap<StateValue, AcceptorController>();
		this.controllers.put(StateValue.INITIAL, new StartController(this.session, this.tcpip));
		this.controllers.put(StateValue.IN_GAME, new PlayController(this.session, this.tcpip));
		this.controllers.put(StateValue.FINAL, new ResumeController(this.session, this.tcpip));
		this.controllers.put(StateValue.EXIT, null);
	}

	public AcceptorController getController() {
		return this.controllers.get(this.session.getValueState());
	}

	public void close() {
		this.tcpip.close();
	}
}
