package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.models.StateValue;
import mastermind.views.Factory;

public class Logic {
	
	private State state;
	
	private Game game;
	
	private Map<StateValue, Controller> controllers;
		
	public Logic(Factory factory) {
		this.state = new State();
		this.game = new Game();
		this.controllers = new HashMap<StateValue, Controller>();
		this.controllers.put(StateValue.INITIAL, new StartController(factory.buildStartView(), this.game, this.state));
		this.controllers.put(StateValue.IN_GAME, new ProposalController(factory.buildProposalView(), this.game, this.state));
		this.controllers.put(StateValue.FINAL, new ResumeController(factory.buildResumeView(), this.game, this.state));
		this.controllers.put(StateValue.EXIT, null);
	}
	
	public Controller getController() {
		return this.controllers.get(this.state.getValueState());
	}
	
}
