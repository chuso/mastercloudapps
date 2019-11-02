package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
		super(game, state);
	}

	public Error move(Coordinate origin, Coordinate target){
		if (game.isFinished()) {
			this.state.next();
			return null;
		} else {
			return game.move(origin, target);
		}
    }

	public Piece getPiece(Coordinate origin) {
		return game.getPiece(origin);
	}

	public Color getColor() {
		return game.getColor();
	}

	@Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
	}

}