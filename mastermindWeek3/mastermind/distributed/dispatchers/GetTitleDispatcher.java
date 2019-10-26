package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;

public class GetTitleDispatcher extends Dispatcher {

    public GetTitleDispatcher(AcceptorController saveControllerImplementation) {
        super(saveControllerImplementation);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorController.getName());
    }

}
