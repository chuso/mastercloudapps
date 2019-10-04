package mastermindWeek2.views.console;

import mastermindWeek2.controllers.Logic;
import mastermindWeek2.models.Result;

public class ResultView {

    private final Logic logic;
    private final int index;

    ResultView(Logic logic, int index) {
        this.logic = logic;
        this.index = index;
    }

    public void writeln() {
        Result result = logic.getResult(index);
        Message.RESULT.writeln(result.getBlacks(), result.getWhites());
    }

}
