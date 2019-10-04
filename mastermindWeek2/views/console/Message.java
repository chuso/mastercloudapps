package mastermindWeek2.views.console;

import mastermindWeek2.utils.IO;

enum Message {
	ATTEMPTS("#attempts attempt(s): "),
	SECRET("*"),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-("),
	NEW_LINE("\n");

	private String message;

	private Message(String message) {
		this.message = message;
	}

	void write() {
		IO.write(this.message);
	}

	void writeln() {
		IO.writeln(this.message);
	}

	void writeln(int attempts) {
		IO.writeln(this.message.replaceAll("#attempts", "" + attempts));
	}

	void writeln(int blacks, int whites) {
		IO.writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
	}

}
