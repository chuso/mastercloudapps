package mastermindWeek3.mastermind.models;

import java.util.List;
import java.util.ArrayList;

import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.santaTecla.utils.Registry;
import mastermindWeek3.mastermind.distributed.dispatchers.TCPIP;
import mastermindWeek3.mastermind.distributed.dispatchers.FrameType;
import mastermindWeek3.mastermind.types.Error;

public class Session {

    private State state;

    private Game game;

    private Registry registry;

    private TCPIP tcpip;

    public Session(TCPIP tcpip) {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
        this.tcpip = tcpip;
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }

    public void next() {
        this.state.next();
    }

    public StateValue getValueState() {
        if (this.tcpip == null) {
            return this.state.getValueState();
        } else {
            this.tcpip.send(FrameType.STATE.name());
            return StateValue.values()[this.tcpip.receiveInt()];
        }
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public void undo() {
        this.registry.undo(this.game);
    }

    public void redo() {
        this.registry.redo(this.game);
    }

    public Error addProposedCombination(List<Color> colors) {
        Error error = game.addProposedCombination(colors);
        if (error == null) {
            this.registry.registry();
        }
        return error;
    }

    public boolean isLooser() {
        if (this.tcpip == null) {
            return this.game.isLooser();
        } else {
            this.tcpip.send(FrameType.ISLOSER.name());
            return this.tcpip.receiveBoolean();
        }
    }

    public boolean isWinner() {
        if (this.tcpip == null) {
            return this.game.isWinner();
        } else {
            this.tcpip.send(FrameType.ISWINNER.name());
            return this.tcpip.receiveBoolean();
        }
    }

    public int getAttempts() {
        if (this.tcpip == null) {
            return this.game.getAttempts();
        } else {
            this.tcpip.send(FrameType.GETATTEMPTS.name());
            return this.tcpip.receiveInt();
        }
    }

    public List<Color> getColors(int position) {
        if (this.tcpip == null) {
            return game.getColors(position);
        } else {
            this.tcpip.send(FrameType.GETCOLORS.name());
            this.tcpip.send(position);
            List<Color> colors = new ArrayList<Color>();
            int size = this.tcpip.receiveInt();
            for (int i = 0; i < size; i++) {
                colors.add(this.tcpip.receiveColor());
            }
            return colors;
        }
    }

    public int getBlacks(int position) {
        if (this.tcpip == null) {
            return this.game.getBlacks(position);
        } else {
            this.tcpip.send(FrameType.GETBLACKS.name());
            this.tcpip.send(position);
            return this.tcpip.receiveInt();
        }
    }

    public int getWhites(int position) {
        if (this.tcpip == null) {
            return this.game.getWhites(position);
        } else {
            this.tcpip.send(FrameType.GETWHITES.name());
            this.tcpip.send(position);
            return this.tcpip.receiveInt();
        }
    }

    public int getWidth() {
        if (this.tcpip == null) {
            return this.game.getWidth();
        } else {
            this.tcpip.send(FrameType.GETWIDTH.name());
            return this.tcpip.receiveInt();
        }
    }

}
