package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.controllers.SaveController;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;
import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.Session;

public class SaveControllerProxy extends SaveController {

    private TCPIP tcpip;

    SaveControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void save(String name) {
        this.tcpip.send(FrameType.SAVE.name());
        this.tcpip.send(name);
    }

    @Override
    public void save() {
        this.tcpip.send(FrameType.SAVENAMED.name());
    }

    @Override
    public void next() {
        this.tcpip.send(FrameType.NEXT.name());
    }

    @Override
    public boolean hasName() {
        this.tcpip.send(FrameType.HASNAME.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean exists(String name) {
        this.tcpip.send(FrameType.EXISTS.name());
        this.tcpip.send(name);
        return this.tcpip.receiveBoolean();
    }

}
