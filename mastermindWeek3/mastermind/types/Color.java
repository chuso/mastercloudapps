package mastermindWeek3.mastermind.types;

import java.io.FileWriter;
import java.io.IOException;

public enum Color {
	RED, 
	BLUE, 
	YELLOW, 
	GREEN, 
	ORANGE, 
	PURPLE;

	public static int length() {
		return Color.values().length;
	}
	
	public void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
