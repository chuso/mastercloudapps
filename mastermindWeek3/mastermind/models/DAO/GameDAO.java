package mastermindWeek3.mastermind.models.DAO;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import mastermindWeek3.mastermind.models.Game;
import mastermindWeek3.mastermind.models.ProposedCombination;
import mastermindWeek3.mastermind.models.Result;

class GameDAO implements DAO {

    private final Game game;

    GameDAO(Game game) {
        this.game = game;
    }

    public void save(FileWriter fileWriter) {
        new CombinationDAO(game.getSecretCombination()).save(fileWriter);
		this.saveAttempts(fileWriter);
		for (ProposedCombination proposedCombination : game.getProposedCombinations()) {
            new CombinationDAO(proposedCombination).save(fileWriter);
		}
		for (Result result : game.getResults()) {
            new ResultDAO(result).save(fileWriter);
		}
    }

    private void saveAttempts(FileWriter fileWriter) {
		try {
			fileWriter.write(this.game.getAttempts() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void load(BufferedReader bufferedReader) {
        new CombinationDAO(game.getSecretCombination()).load(bufferedReader);
        this.loadAttempts(bufferedReader);
        List<ProposedCombination> proposedCombinations = game.getProposedCombinations();
        proposedCombinations.clear();
		for (int i = 0; i < game.getAttempts(); i++) {
            ProposedCombination proposedCombination = new ProposedCombination();
            new CombinationDAO(proposedCombination).load(bufferedReader);
			proposedCombinations.add(proposedCombination);
        }
        List<Result> results = game.getResults();
        results.clear();
		for (int i = 0; i < game.getAttempts(); i++) {
            Result result = new Result();
            new ResultDAO(result).load(bufferedReader);
			results.add(result);
		}
    }

    private void loadAttempts(BufferedReader bufferedReader) {
		try {
            int attempts = Integer.valueOf(bufferedReader.readLine());
            game.setAttempts(attempts);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
