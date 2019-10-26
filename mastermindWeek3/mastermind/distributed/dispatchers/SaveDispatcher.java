package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.implementation.SaveControllerImplementation;

public class SaveDispatcher extends Dispatcher {

    public SaveDispatcher(AcceptorController saveControllerImplementation) {
        super(saveControllerImplementation);
    }

    @Override
    public void dispatch() {
        String name = this.tcpip.receiveLine();
        ((SaveControllerImplementation) this.acceptorController).save(name);
    }

}
