package mastermindWeek3.mastermind.models;

import java.util.List;

import mastermindWeek3.mastermind.types.Color;
public interface Session {

    public StateValue getValueState();

    public boolean isLooser();

    public boolean isWinner();

    public int getAttempts();

    public List<Color> getColors(int position);

    public int getBlacks(int position);

    public int getWhites(int position);

    public int getWidth();

}
