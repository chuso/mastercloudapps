package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.implementation.PlayControllerImplementation;

public class NextDispatcher extends Dispatcher {

    public NextDispatcher(AcceptorController playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        ((PlayControllerImplementation) this.acceptorController).next();
    }

}
