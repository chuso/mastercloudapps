package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.StartController;

public class StartDispatcher extends Dispatcher {

    public StartDispatcher(AcceptorController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        ((StartController) this.acceptorController).start();
    }

}
