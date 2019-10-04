package mastermindWeek2;

import mastermindWeek2.controllers.Controller;
import mastermindWeek2.controllers.Logic;
import mastermindWeek2.views.View;
import mastermindWeek2.views.console.ConsoleView;

public class Mastermind  {

    private Logic logic;
    private View view;

    private Mastermind() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

    private void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }

}
