package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.Mastermind;
import mastermindWeek3.mastermind.views.View;
import mastermindWeek3.mastermind.views.console.ConsoleView;
import mastermindWeek3.mastermind.controllers.Logic;

public class MastermindClient extends Mastermind {

    private LogicProxy logicProxy;

    @Override
    protected View createView() {
        return new ConsoleView();
    }

    @Override
    protected Logic createLogic() {
        this.logicProxy = new LogicProxy();
        return this.logicProxy;
    }

    @Override
    public void play() {
        super.play();
        this.logicProxy.close();
    }

    public static void main(String[] args) {
        new MastermindClient().play();
    }

}
