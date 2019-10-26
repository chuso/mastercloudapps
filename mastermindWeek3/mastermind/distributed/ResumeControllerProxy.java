package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.controllers.ResumeController;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;

public class ResumeControllerProxy extends ResumeController {

    private final TCPIP tcpip;

    public ResumeControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void resume(boolean newGame) {
        this.tcpip.send(FrameType.NEW_GAME.name());
        this.tcpip.send(newGame);
    }

}
