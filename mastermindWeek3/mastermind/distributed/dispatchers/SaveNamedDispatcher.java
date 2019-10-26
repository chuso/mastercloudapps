package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.implementation.SaveControllerImplementation;

public class SaveNamedDispatcher extends Dispatcher {

    public SaveNamedDispatcher(AcceptorController saveControllerImplementation) {
        super(saveControllerImplementation);
    }

    @Override
    public void dispatch() {
        ((SaveControllerImplementation) this.acceptorController).save();
    }

}
