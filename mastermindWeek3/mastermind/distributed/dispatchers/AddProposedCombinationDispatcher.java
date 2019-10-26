package mastermindWeek3.mastermind.distributed.dispatchers;

import java.util.List;
import java.util.ArrayList;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.types.Color;

public class AddProposedCombinationDispatcher extends Dispatcher {

    public AddProposedCombinationDispatcher(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        List<Color> colors = new ArrayList<Color>();
        int size = this.tcpip.receiveInt();
        for (int i = 0; i < size; i++) {
            colors.add(this.tcpip.receiveColor());
        }
        PlayController playController = (PlayController) this.acceptorController;
        this.tcpip.send(playController.addProposedCombination(colors));
    }
}
