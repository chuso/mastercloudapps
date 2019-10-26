package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.implementation.SaveControllerImplementation;

public class HasNameDispatcher extends Dispatcher {

    public HasNameDispatcher(AcceptorController saveControllerImplementation) {
        super(saveControllerImplementation);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((SaveControllerImplementation) this.acceptorController).hasName());
    }

}
