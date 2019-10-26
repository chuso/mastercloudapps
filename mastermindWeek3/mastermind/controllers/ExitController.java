package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.SessionImplementation;

public class ExitController extends Controller {

    public ExitController(Session session) {
        super(session);
    }

    public void next() {
        ((SessionImplementation) this.session).next();
    }

}
