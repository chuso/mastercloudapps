package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;

public class StateDispatcher extends Dispatcher {

    public StateDispatcher(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorController.getValueState().ordinal());
    }
}
