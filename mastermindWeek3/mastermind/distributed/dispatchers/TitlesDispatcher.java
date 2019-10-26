package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.controllers.implementation.StartControllerImplementation;

public class TitlesDispatcher extends Dispatcher {

    public TitlesDispatcher(AcceptorController startControllerImplementation) {
        super(startControllerImplementation);
    }

    @Override
    public void dispatch() {
        String[] names = ((StartControllerImplementation) this.acceptorController).getGamesNames();
        this.tcpip.send(names.length);
        for (int i = 0; i < names.length; i++) {
            this.tcpip.send(names[i]);
        }
    }

}
