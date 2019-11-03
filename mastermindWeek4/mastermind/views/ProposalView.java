package mastermind.views;

import java.util.List;

import mastermind.models.Game;
import mastermind.types.Color;
import mastermind.types.Error;

public interface ProposalView {

	public List<Color> readColors();

	public void printError(Error error);

	public void printGame(Game game);

	public void printIsWinner();

	public void printIsLoser();

}
