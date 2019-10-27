package mastermindWeek3.mastermind.models.DAO;

import java.io.FileWriter;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

import mastermindWeek3.mastermind.models.Combination;
import mastermindWeek3.mastermind.types.Color;

class CombinationDAO implements DAO {

    private final Combination combination;

    public CombinationDAO(Combination combination) {
        this.combination = combination;
    }

    public void save(FileWriter fileWriter) {
        List<Color> colors = combination.getColors();
		try {
			fileWriter.write(colors.size() + "\n");
			for (int i = 0; i < colors.size(); i++) {
				colors.get(i).save(fileWriter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void load(BufferedReader bufferedReader) {
		try {
			List<Color> colors = new ArrayList<Color>();
			Integer size = Integer.valueOf(bufferedReader.readLine());
			for (int i = 0; i < size; i++) {
				colors.add(Color.valueOf(bufferedReader.readLine()));
            }
            this.combination.setColors(colors);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
