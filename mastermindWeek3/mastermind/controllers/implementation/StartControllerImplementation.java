package mastermindWeek3.mastermind.controllers.implementation;

import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.models.Session;

public class StartControllerImplementation extends StartController {

    public StartControllerImplementation(Session session) {
        super(session);
    }

    @Override
    public void start() {
        this.session.next();
    }

}
