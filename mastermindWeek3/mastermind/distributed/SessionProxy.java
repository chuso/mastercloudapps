package mastermindWeek3.mastermind.distributed;

import java.util.List;
import java.util.ArrayList;

import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;
import mastermindWeek3.mastermind.models.StateValue;
import mastermindWeek3.mastermind.models.Session;

public class SessionProxy implements Session {

    private TCPIP tcpip;

    public SessionProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

    @Override
    public StateValue getValueState() {
        this.tcpip.send(FrameType.STATE.name());
        return StateValue.values()[this.tcpip.receiveInt()];
    }

    @Override
    public boolean isLooser() {
        this.tcpip.send(FrameType.ISLOSER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isWinner() {
        this.tcpip.send(FrameType.ISWINNER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public int getAttempts() {
        this.tcpip.send(FrameType.GETATTEMPTS.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public List<Color> getColors(int position) {
        this.tcpip.send(FrameType.GETCOLORS.name());
        this.tcpip.send(position);
        List<Color> colors = new ArrayList<Color>();
        int size = this.tcpip.receiveInt();
        for (int i = 0; i < size; i++) {
            colors.add(this.tcpip.receiveColor());
        }
        return colors;
    }

    @Override
    public int getBlacks(int position) {
        this.tcpip.send(FrameType.GETBLACKS.name());
        this.tcpip.send(position);
        return this.tcpip.receiveInt();
    }

    @Override
    public int getWhites(int position) {
        this.tcpip.send(FrameType.GETWHITES.name());
        this.tcpip.send(position);
        return this.tcpip.receiveInt();
    }

    @Override
    public int getWidth() {
        this.tcpip.send(FrameType.GETWIDTH.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public String getName() {
        this.tcpip.send(FrameType.GETTITLE.name());
        return this.tcpip.receiveLine();
    }

    @Override
    public void setName(String title) {
        this.tcpip.send(FrameType.SETTITLE.name());
        this.tcpip.send(title);
    }

}
