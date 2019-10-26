package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.implementation.SaveControllerImplementation;

public class ExistsDispatcher extends Dispatcher {

    public ExistsDispatcher(AcceptorController saveControllerImplementation) {
        super(saveControllerImplementation);
    }

    @Override
    public void dispatch() {
        String name = this.tcpip.receiveLine();
        this.tcpip.send(((SaveControllerImplementation) this.acceptorController).exists(name));
    }

}
