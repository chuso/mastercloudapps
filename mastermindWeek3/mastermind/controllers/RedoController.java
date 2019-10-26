package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.SessionImplementation;

public class RedoController extends Controller {

    public RedoController(Session session) {
        super(session);
    }

    public void redo() {
        ((SessionImplementation) this.session).redo();
    }

    public boolean redoable() {
        return ((SessionImplementation) this.session).redoable();
    }
}
