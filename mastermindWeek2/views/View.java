package mastermindWeek2.views;

import mastermindWeek2.controllers.Controller;
import mastermindWeek2.controllers.ControllerVisitor;


public abstract class View implements ControllerVisitor {

    public abstract void interact(Controller controller);

}
