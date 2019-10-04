package mastermindWeek2.views.console;

import mastermindWeek2.models.SecretCombination;

public class SecretCombinationView {

    private final SecretCombination secretCombination;

    public SecretCombinationView(SecretCombination secretCombination) {
        this.secretCombination = secretCombination;
    }

    public void writeln() {
		for (int i = 0; i < secretCombination.getSize(); i++) {
			Message.SECRET.write();
		}
		Message.NEW_LINE.write();
    }

}
