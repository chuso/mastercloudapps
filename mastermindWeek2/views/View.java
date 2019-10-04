package mastermindWeek2.views;

import mastermindWeek2.controllers.ProposeController;
import mastermindWeek2.controllers.ResumeController;
import mastermindWeek2.controllers.StartController;

public abstract class View {

    protected ProposeController proposeController;
    protected ResumeController resumeController;
    protected StartController startController;

    public View(ProposeController proposeController, ResumeController resumeController, StartController startController) {
        this.proposeController = proposeController;
        this.resumeController = resumeController;
        this.startController = startController;
    }

    public void interact() {
        boolean resume;
        do {
            this.start();
            boolean finished;
            do {
                this.move();
                finished = proposeController.isGameFinished();
            } while (!finished);
            resume = this.resume();
            if (resume) {
                resumeController.resume();
            }
        } while (resume);
    }

    protected abstract void start();

    protected abstract void move();

    protected abstract boolean resume();
}
