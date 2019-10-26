package mastermindWeek3.mastermind.controllers.implementation;

import java.util.List;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.controllers.ProposalController;
import mastermindWeek3.mastermind.controllers.UndoController;
import mastermindWeek3.mastermind.controllers.RedoController;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.types.Error;

public class PlayControllerImplementation extends PlayController {

    private ProposalController proposalController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayControllerImplementation(Session session) {
        super(session);
        this.proposalController = new ProposalController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    @Override
    public Error addProposedCombination(List<Color> colors) {
        return proposalController.addProposedCombination(colors);
    }

    @Override
    public void undo() {
        this.undoController.undo();
    }

    @Override
    public void redo() {
        this.redoController.redo();
    }

    @Override
    public boolean undoable() {
        return this.undoController.undoable();
    }

    @Override
    public boolean redoable() {
        return this.redoController.redoable();
    }

}
