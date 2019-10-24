package mastermindWeek3.mastermind.controllers;

import java.util.List;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.types.Error;
import mastermindWeek3.mastermind.models.Session;

public class PlayController extends AcceptorController {

    private ProposalController proposalController;
    private UndoController undoController;
    private RedoController redoController;

    PlayController(Session session) {
        super(session);
        this.proposalController = new ProposalController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    public Error addProposedCombination(List<Color> colors) {
        return proposalController.addProposedCombination(colors);
    }

    public List<Color> getColors(int position) {
        return proposalController.getColors(position);
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

    public boolean isWinner() {
        return proposalController.isWinner();
    }

    public boolean isLoser() {
        return proposalController.isLooser();
    }

    public int getAttempts() {
        return this.proposalController.getAttempts();
    }

    public int getBlacks(int position) {
        return this.proposalController.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.proposalController.getWhites(position);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
