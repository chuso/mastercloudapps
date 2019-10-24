package mastermindWeek3.mastermind.controllers;

import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.Session;

public abstract class AcceptorController extends Controller {

    protected TCPIP tcpip;

    AcceptorController(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    public abstract void accept(ControllersVisitor controllersVisitor);

}
