package mastermindWeek3.mastermind.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

class Result {

	private int blacks = 0;

	private int whites = 0;

	Result() {
	}

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	boolean isWinner() {
		return this.blacks == Combination.getWidth();
	}

	int getBlacks() {
		return this.blacks;
	}

	int getWhites() {
		return this.whites;
	}

	public Result copy() {
		return new Result(blacks, whites);
	}

	void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.blacks + "\n");
			fileWriter.write(this.whites + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load(BufferedReader bufferedReader) {
		try {
			blacks = Integer.valueOf(bufferedReader.readLine());
			whites = Integer.valueOf(bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
