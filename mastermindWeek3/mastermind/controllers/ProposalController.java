package mastermindWeek3.mastermind.controllers;

import java.util.List;

import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.types.Error;

public class ProposalController extends Controller {

	public ProposalController(Session session) {
		super(session);
	}

	public Error addProposedCombination(List<Color> colors) {
		Error error = this.session.addProposedCombination(colors);
		if (error == null && (this.session.isWinner() || this.session.isLooser())) {
			this.session.next();
		}
		return error;	
	}

}
