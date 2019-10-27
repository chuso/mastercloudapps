package damas.controllers;

import damas.models.Game;
import damas.models.Coordinate;
import damas.models.Piece;

class PlayController extends AcceptorController {

    public PlayController(Game game) {
		super(game);
	}

	public Error move(Coordinate origin, Coordinate target){
        return null;
    }

	public Piece getPiece(Coordinate origin) {
		return null;
	}

}
