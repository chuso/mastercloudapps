package mastermindWeek3.mastermind.distributed.dispatchers;

import mastermindWeek3.mastermind.controllers.AcceptorController;

public class SetTitleDispatcher extends Dispatcher {

    public SetTitleDispatcher(AcceptorController saveControllerImplementation) {
        super(saveControllerImplementation);
    }

    @Override
    public void dispatch() {
        String title = this.tcpip.receiveLine();
        this.acceptorController.setName(title);
    }

}
