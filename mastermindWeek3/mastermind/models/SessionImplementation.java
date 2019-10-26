package mastermindWeek3.mastermind.models;

import java.io.*;
import java.util.List;

import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.santaTecla.utils.Registry;
import mastermindWeek3.mastermind.types.Error;

public class SessionImplementation implements Session {

    public static final String EXTENSION = ".mm";

    public static final String DIRECTORY = System.getProperty("user.dir") + "/partidas";

    private static File directory;

    static {
        SessionImplementation.directory = new File(SessionImplementation.DIRECTORY);
        if (!SessionImplementation.directory.exists()) {
            SessionImplementation.directory.mkdir();
        }
    }

    private State state;

    private Game game;

    private Registry registry;

    private String name;

    public SessionImplementation() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    public void load(String name) {
        this.name = name;
        File file = new File(SessionImplementation.directory, name);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            this.game.load(bufferedReader);
            this.registry.reset();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.state.setStateValue(StateValue.IN_GAME);
        if (this.isLooser() || this.isWinner()) {
            this.state.setStateValue(StateValue.FINAL);
        }
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }

    public void next() {
        this.state.next();
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

    public void save() {
        this.save(this.name);
    }

    public void save(String name) {
        if (!name.endsWith(SessionImplementation.EXTENSION)) {
            name = name + SessionImplementation.EXTENSION;
        }
        File file = new File(SessionImplementation.directory, name);
        try {
            FileWriter fileWriter = new FileWriter(file);
            this.game.save(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasName() {
        return this.name != null;
    }

    public String[] getGamesNames() {
        return SessionImplementation.directory.list();
    }

    public boolean exists(String name) {
        for (String auxName : this.getGamesNames()) {
            if (auxName.equals(name + SessionImplementation.EXTENSION)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public StateValue getValueState() {
        return this.state.getValueState();
    }

    @Override
    public boolean isLooser() {
        return this.game.isLooser();
    }

    @Override
    public boolean isWinner() {
        return this.game.isWinner();
    }

    @Override
    public int getAttempts() {
        return this.game.getAttempts();
    }

    @Override
    public List<Color> getColors(int position) {
        return game.getColors(position);
    }

    @Override
    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

    @Override
    public int getWidth() {
        return this.game.getWidth();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
