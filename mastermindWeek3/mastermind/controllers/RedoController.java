package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Session;

class RedoController extends Controller {

    public RedoController(Session session) {
        super(session);
    }

    public void redo() {
        this.session.redo();
    }

    public boolean redoable() {
        return this.session.redoable();
    }
}
