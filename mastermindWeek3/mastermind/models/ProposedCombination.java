package mastermindWeek3.mastermind.models;

import java.util.List;

import mastermindWeek3.mastermind.types.Color;

class ProposedCombination extends Combination {

	private ProposedCombination() {
	}

	ProposedCombination(List<Color> colors) {
		this.colors = colors;
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}

	public ProposedCombination copy() {
		ProposedCombination copy = new ProposedCombination();
		copy.copyColorsFrom(this);
		return copy;
	}

}
