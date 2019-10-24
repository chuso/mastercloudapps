package mastermindWeek3.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermindWeek3.mastermind.models.Game;
import mastermindWeek3.mastermind.models.State;
import mastermindWeek3.mastermind.models.StateValue;

public class Logic {
	
	private State state;
	
	private Game game;
	
	private Map<StateValue, AcceptorController> controllers;
		
	public Logic() {
		this.state = new State();
		this.game = new Game();
		this.controllers = new HashMap<StateValue, AcceptorController>();
		this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
		this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
		this.controllers.put(StateValue.FINAL, new ResumeController(this.game, this.state));
		this.controllers.put(StateValue.EXIT, null);
	}
	
	public AcceptorController getController() {
		return this.controllers.get(this.state.getValueState());
	}
	
}
