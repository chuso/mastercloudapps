package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.Mastermind;
import mastermindWeek3.mastermind.views.View;
import mastermindWeek3.mastermind.views.console.ConsoleView;

public class MastermindClient extends Mastermind {

    @Override
    protected View createView() {
        return new ConsoleView();
    }

    @Override
    protected Boolean isStandalone() {
        return false;
    }

    public static void main(String[] args) {
        new MastermindClient().play();
    }

}
