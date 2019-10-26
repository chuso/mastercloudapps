package mastermindWeek3.mastermind.controllers;

import java.util.List;
import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.types.Error;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;

public class PlayController extends AcceptorController {

    private ProposalController proposalController;
    private UndoController undoController;
    private RedoController redoController;

    PlayController(Session session, TCPIP tcpip) {
        super(session, tcpip);
        if (tcpip == null) {
            this.proposalController = new ProposalController(session);
            this.undoController = new UndoController(session);
            this.redoController = new RedoController(session);
        }
    }

    public Error addProposedCombination(List<Color> colors) {
        if (this.tcpip == null) {
            return proposalController.addProposedCombination(colors);
        } else {
            this.tcpip.send(FrameType.ADDPROPOSEDCOMBINATION.name());
            this.tcpip.send(colors.size());
            for (int i = 0; i < colors.size(); i++) {
                this.tcpip.send(colors.get(i));
            }
            return this.tcpip.receiveError();
        }
    }

    public void undo() {
        if (this.tcpip == null) {
            this.undoController.undo();
        } else {
            this.tcpip.send(FrameType.UNDO.name());
        }
    }

    public void redo() {
        if (this.tcpip == null) {
            this.redoController.redo();
        } else {
            this.tcpip.send(FrameType.REDO.name());
        }
    }

    public boolean undoable() {
        if (this.tcpip == null) {
            return this.undoController.undoable();
        }
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    public boolean redoable() {
        if (this.tcpip == null) {
            return this.redoController.redoable();
        }
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
