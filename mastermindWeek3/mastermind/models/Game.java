package mastermindWeek3.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermindWeek3.mastermind.types.Color;

public class Game {

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

	public void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.attempts++;
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
		Memento memento = new Memento();
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
		this.secretCombination = memento.getSecretCombination().copy();
		this.attempts = memento.getAttempts();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		for (int i = 0; i < attempts; i++) {
			this.proposedCombinations.add(memento.getProposedCombination(i).copy());
		}
		this.results = new ArrayList<Result>();
		for (int i = 0; i < attempts; i++) {
			this.results.add(memento.getResult(i).copy());
		}
	}

}
