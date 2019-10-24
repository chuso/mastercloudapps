package mastermindWeek3.mastermind.models;

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

}
