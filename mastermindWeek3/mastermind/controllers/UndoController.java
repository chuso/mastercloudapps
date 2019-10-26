package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.SessionImplementation;;

public class UndoController extends Controller {

    public UndoController(Session session) {
        super(session);
    }

    public void undo() {
        ((SessionImplementation) this.session).undo();
    }

    public boolean undoable() {
        return ((SessionImplementation) this.session).undoable();
    }
}
