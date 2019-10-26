package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.controllers.AcceptorController;

public class RedoDispatcher extends Dispatcher {

    public RedoDispatcher(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) this.acceptorController).redo();
    }

}
