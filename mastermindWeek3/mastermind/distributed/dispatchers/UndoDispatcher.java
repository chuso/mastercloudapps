package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.controllers.AcceptorController;

public class UndoDispatcher extends Dispatcher {

    public UndoDispatcher(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) this.acceptorController).undo();
    }

}
