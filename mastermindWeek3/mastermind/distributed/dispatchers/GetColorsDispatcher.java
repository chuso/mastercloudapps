package mastermindWeek3.mastermind.distributed.dispatchers;

import java.util.List;
import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.types.Color;

public class GetColorsDispatcher extends Dispatcher {

    public GetColorsDispatcher(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        PlayController playController = (PlayController) this.acceptorController;
        List<Color> colors = playController.getColors(position);
        int size = colors.size();
        this.tcpip.send(size);
        for (int i = 0; i < size; i++) {
            this.tcpip.send(colors.get(i));
        }
    }
}
