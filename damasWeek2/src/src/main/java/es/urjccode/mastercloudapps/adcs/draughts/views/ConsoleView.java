package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.ControllerVisitor;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.*;

public class ConsoleView implements ControllerVisitor {
    
    public void interact(Controller controller) {
        controller.accept(this);
    }

    public void visit(StartController startController) {
        new StartView(startController).writeln();
    }

    public void visit(PlayController playController) {
        new CommandView(playController).interact();
    }

    public void visit(ResumeController resumeController) {
        new ResumeView(resumeController).interact();
    }
}