package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.ResumeController;
import mastermindWeek3.mastermind.controllers.AcceptorController;

public class ResumeDispatcher extends Dispatcher {

    public ResumeDispatcher(AcceptorController resumeController) {
        super(resumeController);
    }

    @Override
    public void dispatch() {
        boolean newGame = this.tcpip.receiveBoolean();
        ((ResumeController) this.acceptorController).resume(newGame);
    }

}
