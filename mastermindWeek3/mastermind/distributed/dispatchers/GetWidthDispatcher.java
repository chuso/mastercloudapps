package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;

public class GetWidthDispatcher extends Dispatcher {

    public GetWidthDispatcher(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorController.getWidth());
    }
}
