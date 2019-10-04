package mastermindWeek2.models;

public class ProposedCombination extends Combination {

    public ProposedCombination(String characters) {
        super();
        for (int i = 0; i < characters.length(); i++) {
            colors.add(Color.getInstance(characters.charAt(i)));
        }
    }

    public static Error validate(String characters) {
        if (characters.length() != Combination.getWidth()) {
            return Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < characters.length(); i++) {
                Color color = Color.getInstance(characters.charAt(i));
                if (color == null) {
                    return Error.WRONG_CHARACTERS;
                }
                for (int j = i + 1; j < characters.length(); j++) {
                    if (characters.charAt(i) == characters.charAt(j)) {
                        return Error.DUPLICATED;
                    }
                }
            }
		}
		return null;
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

}
