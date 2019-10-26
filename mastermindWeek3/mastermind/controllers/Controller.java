package mastermindWeek3.mastermind.controllers;

import java.util.List;

import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.models.StateValue;
import mastermindWeek3.mastermind.types.Color;

public abstract class Controller {

	protected Session session;

	Controller(Session session) {
		this.session = session;
	}

	public StateValue getValueState() {
		return this.session.getValueState();
	}

	public int getAttempts() {
		return this.session.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.session.getColors(position);
	}

	public int getBlacks(int position) {
		return this.session.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.session.getWhites(position);
	}

	public boolean isWinner() {
		return this.session.isWinner();
	}

	public boolean isLoser() {
		return this.session.isLooser();
	}

	public int getWidth() {
		return this.session.getWidth();
	}

}
