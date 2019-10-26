package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Session;

public class UndoController extends Controller {

    public UndoController(Session session) {
        super(session);
    }

    public void undo() {
        this.session.undo();
    }

    public boolean undoable() {
        return this.session.undoable();
    }
}
