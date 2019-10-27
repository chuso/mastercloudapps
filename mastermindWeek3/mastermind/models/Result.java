package mastermindWeek3.mastermind.models;

public class Result {

	private int blacks = 0;

	private int whites = 0;

	public Result() {
	}

	Result(int blacks, int whites) {
		this.setBlacks(blacks);
		this.setWhites(whites);

	}

	boolean isWinner() {
		return this.blacks == Combination.getWidth();
	}

	public void setBlacks(int blacks) {
		assert blacks >= 0;
		this.blacks = blacks;
	}

	public int getBlacks() {
		return this.blacks;
	}

	public void setWhites(int whites) {
		assert whites >= 0;
		this.whites = whites;
	}

	public int getWhites() {
		return this.whites;
	}

	public Result copy() {
		return new Result(blacks, whites);
	}

}
