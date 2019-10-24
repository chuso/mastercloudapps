package mastermindWeek3.mastermind.models;

import java.util.List;

import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.santaTecla.utils.Registry;
import mastermindWeek3.mastermind.distributed.TCPIP;

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
        return this.state.getValueState();
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

    public void addProposedCombination(List<Color> colors) {
        game.addProposedCombination(colors);
        this.registry.registry();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public int getAttempts() {
		return this.game.getAttempts();
	}

	public List<Color> getColors(int position) {
		return game.getColors(position);
	}

	public int getBlacks(int position) {
		return game.getBlacks(position);
	}

	public int getWhites(int position) {
		return game.getWhites(position);
	}

	public int getWidth() {
		return game.getWidth();
	}

}
