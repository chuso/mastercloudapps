package mastermindWeek3.mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermindWeek3.mastermind.models.Result;

class ResultDAO implements DAO {

    private final Result result;

    public ResultDAO(Result result) {
        this.result = result;
    }

    public void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.result.getBlacks() + "\n");
			fileWriter.write(this.result.getWhites() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void load(BufferedReader bufferedReader) {
		try {
			int blacks = Integer.valueOf(bufferedReader.readLine());
            int whites = Integer.valueOf(bufferedReader.readLine());
            this.result.setBlacks(blacks);
            this.result.setWhites(whites);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
