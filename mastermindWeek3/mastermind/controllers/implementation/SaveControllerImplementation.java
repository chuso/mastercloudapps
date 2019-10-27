package mastermindWeek3.mastermind.controllers.implementation;

import mastermindWeek3.mastermind.controllers.SaveController;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.SessionImplementation;
import mastermindWeek3.mastermind.models.DAO.SessionImplementationDAO;

public class SaveControllerImplementation extends SaveController {

    private final SessionImplementationDAO sessionImplementationDAO;

    SaveControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
    }

    @Override
    public void save(String name) {
        sessionImplementationDAO.save(name);
    }

    @Override
    public void save() {
        sessionImplementationDAO.save();
    }

    @Override
    public void next() {
        ((SessionImplementation) this.session).next();
    }

    @Override
    public boolean hasName() {
        return ((SessionImplementation) this.session).hasName();
    }

    @Override
    public boolean exists(String name) {
        return sessionImplementationDAO.exists(name);
    }

}
