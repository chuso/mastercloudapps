package mastermindWeek3.mastermind.controllers.implementation;

import mastermindWeek3.mastermind.controllers.SaveController;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.SessionImplementation;

public class SaveControllerImplementation extends SaveController {

    SaveControllerImplementation(Session session) {
        super(session);
    }

    @Override
    public void save(String name) {
        ((SessionImplementation) this.session).save(name);
    }

    @Override
    public void save() {
        ((SessionImplementation) this.session).save();
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
        return ((SessionImplementation) this.session).exists(name);
    }

}
