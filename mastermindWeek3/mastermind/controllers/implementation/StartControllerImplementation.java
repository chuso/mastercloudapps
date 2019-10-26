package mastermindWeek3.mastermind.controllers.implementation;

import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

    public StartControllerImplementation(Session session) {
        super(session);
    }

    @Override
    public void start() {
        ((SessionImplementation) this.session).next();
    }

}
