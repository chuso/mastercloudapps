package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.controllers.AcceptorController;

public class IsWinnerDispatcher extends Dispatcher {

    public IsWinnerDispatcher(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController) this.acceptorController).isWinner());
    }
}
