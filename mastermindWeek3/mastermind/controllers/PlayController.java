package mastermindWeek3.mastermind.controllers;

import java.util.List;
import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.types.Error;
import mastermindWeek3.mastermind.models.Session;

public class PlayController extends AcceptorController {

    private ProposalController proposalController;
    private UndoController undoController;
    private RedoController redoController;

    PlayController(Session session, TCPIP tcpip) {
        super(session, tcpip);
        this.proposalController = new ProposalController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    public Error addProposedCombination(List<Color> colors) {
        return proposalController.addProposedCombination(colors);
    }

    public void undo() {
        undoController.undo();
    }

    public void redo() {
        redoController.redo();
    }

    public boolean undoable() {
        return undoController.undoable();
    }

    public boolean redoable() {
        return redoController.redoable();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
