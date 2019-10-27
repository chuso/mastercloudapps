package damas.models;

import damas.types.Error;

public class Game {

	public Error move(Coordinate ...coordinates) {
		return null;
	}

	public Piece getPiece(Coordinate coordinate) {
		return null;
	}

	public boolean isGameFinished() {
		return false;
	}

	public Board getBoard() {
		return null;
	}

	public void loadFromString(String status, Turn turn) {
		// TODO: replace with any other mechanism. For example:
		// 1.- Use the Memento pattern.
		// 2.- Expose a getBoard() and getTurn() methods so that we can directly tamper with those objects to change Game status.
	}

}
