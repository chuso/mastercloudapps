package mastermindWeek3.mastermind.controllers.implementation;

import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.SessionImplementation;
import mastermindWeek3.mastermind.controllers.ResumeController;
import mastermindWeek3.mastermind.controllers.ControllersVisitor;

public class ResumeControllerImplementation extends ResumeController {

    public ResumeControllerImplementation(Session session) {
        super(session);
    }

    public void resume(boolean newGame) {
        if (newGame) {
            ((SessionImplementation) this.session).resume();
        } else {
            ((SessionImplementation) this.session).next();
        }
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
