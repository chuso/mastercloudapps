package mastermindWeek3.mastermind.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.santaTecla.utils.Memento;
import mastermindWeek3.santaTecla.utils.Originator;
import mastermindWeek3.mastermind.types.Error;

public class Game implements Originator {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	public Game() {
		this.clear();
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	public Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i + 1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}
			}
		}

		if (error == null) {
			ProposedCombination proposedCombination = new ProposedCombination(colors);
			this.proposedCombinations.add(proposedCombination);
			this.results.add(this.secretCombination.getResult(proposedCombination));
			this.attempts++;
		}
		return error;
	}

	public boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}

	public boolean isWinner() {
		return this.attempts != 0 && this.results.get(this.attempts - 1).isWinner();
	}

	public int getAttempts() {
		return this.attempts;
	}

	public List<Color> getColors(int position) {
		return this.proposedCombinations.get(position).colors;
	}

	public int getBlacks(int position) {
		return this.results.get(position).getBlacks();
	}

	public int getWhites(int position) {
		return this.results.get(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	public Memento createMemento() {
		GameMemento memento = new GameMemento();
		memento.setSecretCombination(this.secretCombination.copy());
		for (ProposedCombination proposedCombination : proposedCombinations) {
			memento.addProposedCombination(proposedCombination.copy());
		}
		for (Result result : results) {
			memento.addResult(result.copy());
		}
		memento.setAttempts(attempts);
		return memento;
	}

	public void restore(Memento memento) {
		GameMemento gameMemento = (GameMemento) memento;
		this.secretCombination = gameMemento.getSecretCombination().copy();
		this.attempts = gameMemento.getAttempts();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		for (int i = 0; i < attempts; i++) {
			this.proposedCombinations.add(gameMemento.getProposedCombination(i).copy());
		}
		this.results = new ArrayList<Result>();
		for (int i = 0; i < attempts; i++) {
			this.results.add(gameMemento.getResult(i).copy());
		}
	}

	void save(FileWriter fileWriter) {
		this.secretCombination.save(fileWriter);
		this.saveAttempts(fileWriter);
		for (ProposedCombination proposedCombination : proposedCombinations) {
			proposedCombination.save(fileWriter);
		}
		for (Result result : results) {
			result.save(fileWriter);
		}
	}

	private void saveAttempts(FileWriter fileWriter) {
		try {
			fileWriter.write(this.attempts + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load(BufferedReader bufferedReader) {
		this.secretCombination.load(bufferedReader);
		this.loadAttempts(bufferedReader);
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		for (int i = 0; i < attempts; i++) {
			ProposedCombination proposedCombination = new ProposedCombination();
			proposedCombination.load(bufferedReader);
			this.proposedCombinations.add(proposedCombination);
		}
		for (int i = 0; i < attempts; i++) {
			Result result = new Result();
			result.load(bufferedReader);
			this.results.add(result);
		}
	}

	private void loadAttempts(BufferedReader bufferedReader) {
		try {
			this.attempts = Integer.valueOf(bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
