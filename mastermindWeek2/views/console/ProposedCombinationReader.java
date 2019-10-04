package mastermindWeek2.views.console;

import mastermindWeek2.models.ProposedCombination;
import mastermindWeek2.models.Error;
import mastermindWeek2.utils.IO;

class ProposedCombinationReader {

    public static ProposedCombination read() {
        String characters;
        Error error;
        do {
            Message.PROPOSED_COMBINATION.write();
            characters = IO.readString();
            error = ProposedCombination.validate(characters);
            if (error != null) {
                IO.writeln(error.getMessage());
            }
        } while (error != null);
        return new ProposedCombination(characters);
    }

}
