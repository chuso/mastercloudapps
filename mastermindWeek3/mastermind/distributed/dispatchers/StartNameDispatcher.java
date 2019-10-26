package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.implementation.StartControllerImplementation;

public class StartNameDispatcher extends Dispatcher {

    public StartNameDispatcher(AcceptorController startControllerImplementation) {
        super(startControllerImplementation);
    }

    @Override
    public void dispatch() {
        String title = this.tcpip.receiveLine();
        ((StartControllerImplementation) this.acceptorController).start(title);
    }

}
