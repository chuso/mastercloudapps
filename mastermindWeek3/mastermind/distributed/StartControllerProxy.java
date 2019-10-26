package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;

public class StartControllerProxy extends StartController {

    private final TCPIP tcpip;

    public StartControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void start() {
        this.tcpip.send(FrameType.START.name());
    }

    @Override
    public void start(String title) {
        this.tcpip.send(FrameType.STARTNAME.name());
        this.tcpip.send(title);
    }

    @Override
    public String[] getGamesNames() {
        this.tcpip.send(FrameType.TITLES.name());
        int length = this.tcpip.receiveInt();
        String[] names = new String[length];
        for (int i = 0; i < length; i++) {
            names[i] = this.tcpip.receiveLine();
        }
        return names;
    }

}
