package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.controllers.Logic;
import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.StateValue;

public class LogicProxy extends Logic {

	private TCPIP tcpip;

	public LogicProxy() {
        super();
        this.tcpip = TCPIP.createClientSocket();
		this.session = new SessionProxy(tcpip);
		this.controllers.put(StateValue.INITIAL, new StartControllerProxy(session, tcpip));
		this.controllers.put(StateValue.IN_GAME, new PlayControllerProxy(session, tcpip));
		this.controllers.put(StateValue.SAVING, new SaveControllerProxy(session, tcpip));
		this.controllers.put(StateValue.FINAL, new ResumeControllerProxy(session, tcpip));
		this.controllers.put(StateValue.EXIT, null);
	}

	public void close() {
		this.tcpip.close();
	}
}
