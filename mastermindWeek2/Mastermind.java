package mastermindWeek2;

import mastermindWeek2.controllers.ProposeController;
import mastermindWeek2.controllers.ResumeController;
import mastermindWeek2.controllers.StartController;
import mastermindWeek2.models.Game;
import mastermindWeek2.views.View;
import mastermindWeek2.views.console.ConsoleView;

public class Mastermind  {

    private View view;
    private Game game;

    private Mastermind() {
        this.game = new Game();
        ProposeController proposeController = new ProposeController(this.game);
        ResumeController resumeController = new ResumeController(this.game);
        StartController startController = new StartController(this.game);
        this.view = new ConsoleView(proposeController, resumeController, startController);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

    private void play() {
        view.interact();
    }

}
