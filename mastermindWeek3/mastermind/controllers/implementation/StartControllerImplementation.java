package mastermindWeek3.mastermind.controllers.implementation;

import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.SessionImplementation;
import mastermindWeek3.mastermind.models.DAO.SessionImplementationDAO;

public class StartControllerImplementation extends StartController {

    private final SessionImplementationDAO sessionImplementationDAO;

    public StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
    }

    @Override
    public void start() {
        ((SessionImplementation) this.session).next();
    }

    @Override
    public void start(String name) {
        sessionImplementationDAO.load(name);
    }

    @Override
    public String[] getGamesNames() {
        return sessionImplementationDAO.getGamesNames();
    }

}
