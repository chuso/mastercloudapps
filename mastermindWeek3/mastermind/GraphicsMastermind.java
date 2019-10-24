package mastermindWeek3.mastermind;

import mastermindWeek3.mastermind.views.View;
import mastermindWeek3.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind{

	protected View createView() {
		return new GraphicsView();
	}
	
	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
