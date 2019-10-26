package mastermindWeek3.mastermind.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mastermindWeek3.mastermind.types.Color;

public abstract class Combination {

	private static final int WIDTH = 4;

	protected List<Color> colors;

	protected Combination() {
		this.colors = new ArrayList<Color>();
	}

	protected void copyColorsFrom(Combination combination) {
		List<Color> copiedColors = new ArrayList<>();
		for (Color color : combination.colors) {
			copiedColors.add(color);
		}
		this.colors = new ArrayList<Color>();
		this.colors.addAll(copiedColors);
	}

	public static int getWidth() {
		return Combination.WIDTH;
	}

	void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.colors.size() + "\n");
			for (int i = 0; i < this.colors.size(); i++) {
				this.colors.get(i).save(fileWriter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load(BufferedReader bufferedReader) {
		try {
			this.colors = new ArrayList<Color>();
			Integer size = Integer.valueOf(bufferedReader.readLine());
			for (int i = 0; i < size; i++) {
				this.colors.add(Color.valueOf(bufferedReader.readLine()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
