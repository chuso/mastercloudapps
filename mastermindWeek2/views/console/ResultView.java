package mastermindWeek2.views.console;

import mastermindWeek2.controllers.ProposeController;
import mastermindWeek2.models.Result;

public class ResultView {

    private final ProposeController proposeController;
    private final int index;

    ResultView(ProposeController proposeController, int index) {
        this.proposeController = proposeController;
        this.index = index;
    }

    public void writeln() {
        Result result = proposeController.getResult(index);
        Message.RESULT.writeln(result.getBlacks(), result.getWhites());
    }

}
