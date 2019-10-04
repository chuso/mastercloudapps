package mastermindWeek2;

import mastermindWeek2.controllers.Logic;
import mastermindWeek2.views.View;
import mastermindWeek2.views.console.ConsoleView;

public class Mastermind  {

    private View view;

    private Mastermind() {
        Logic logic = new Logic();
        this.view = new ConsoleView(logic);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

    private void play() {
        view.interact();
    }

}
