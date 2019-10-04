package mastermindWeek2.views;

import mastermindWeek2.controllers.Logic;

public abstract class View {

    protected Logic logic;

    public View(Logic logic) {
        this.logic = logic;
    }

    public void interact() {
        boolean resume;
        do {
            this.start();
            boolean finished;
            do {
                this.move();
                finished = logic.isGameFinished();
            } while (!finished);
            resume = this.resume();
            if (resume) {
                logic.resume();
            }
        } while (resume);
    }

    protected abstract void start();

    protected abstract void move();

    protected abstract boolean resume();
}
