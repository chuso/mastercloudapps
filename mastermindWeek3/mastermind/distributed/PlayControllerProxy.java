package mastermindWeek3.mastermind.distributed;

import java.util.List;
import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.types.Error;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;

public class PlayControllerProxy extends PlayController {

    private final TCPIP tcpip;

    public PlayControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public Error addProposedCombination(List<Color> colors) {
        this.tcpip.send(FrameType.ADDPROPOSEDCOMBINATION.name());
        this.tcpip.send(colors.size());
        for (int i = 0; i < colors.size(); i++) {
            this.tcpip.send(colors.get(i));
        }
        return this.tcpip.receiveError();
    }

    @Override
    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    @Override
    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    @Override
    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

}
