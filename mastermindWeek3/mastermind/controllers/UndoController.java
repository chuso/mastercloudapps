package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Session;

class UndoController extends Controller {

    public UndoController(Session session) {
        super(session);
    }

    public void undo() {
        System.out.println("Undo");
    }

    public boolean undoable() {
        return false;
    }
}
