package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.controllers.AcceptorController;

public class GetWhitesDispatcher extends Dispatcher {

    public GetWhitesDispatcher(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController) this.acceptorController).getWhites(this.tcpip.receiveInt()));
    }
}
