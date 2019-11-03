package mastermind;

import mastermind.views.Factory;

public class ConsoleMastermind extends Mastermind{
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}

	protected Factory buildViewFactory() {
		return new mastermind.views.console.Factory();
	}
}
