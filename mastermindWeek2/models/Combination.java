package mastermindWeek2.models;

import java.util.List;
import java.util.ArrayList;

abstract class Combination {

	private static final int WIDTH = 4;

	protected List<Color> colors;

	protected Combination() {
		this.colors = new ArrayList<Color>();
	}

	public List<Color> getColors() {
		return colors;
	}

	static int getWidth() {
		return Combination.WIDTH;
	}

}
