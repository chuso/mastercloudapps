package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;

public class StartControllerProxy extends StartController {

    private final TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
	}

    @Override
	public void start() {
        this.tcpip.send(FrameType.START.name());
	}

}
