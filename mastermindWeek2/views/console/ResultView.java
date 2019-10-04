package mastermindWeek2.views.console;

import mastermindWeek2.models.Result;

public class ResultView {

    private final Result result;

    ResultView(Result result) {
        this.result = result;
    }

    public void writeln() {
        Message.RESULT.writeln(result.getBlacks(), result.getWhites());
    }

}
