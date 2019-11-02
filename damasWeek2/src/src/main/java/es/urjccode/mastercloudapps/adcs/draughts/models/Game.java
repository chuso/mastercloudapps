package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Game {

	private Board board;
	private Turn turn;

	public Game() {
		this.clear();
	}

	public void clear() {
		this.board = new Board();
		this.turn = new Turn();
	}

	public Error move(Coordinate origin, Coordinate target) {
		if (!origin.isValid() || !target.isValid()) {
			return Error.OUT_COORDINATE;
		}
		if (board.isEmpty(origin)) {
			return Error.EMPTY_ORIGIN;
		}
		Color color = this.board.getColor(origin);
		if (!this.turn.isColor(color)) {
			return Error.OPPOSITE_PIECE;
		}
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		Piece piece = this.board.getPiece(origin);
		if (!piece.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
		}
		if (origin.diagonalDistance(target) >= 3) {
			return Error.BAD_DISTANCE;
		}
		if (!this.board.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		if (origin.diagonalDistance(target) == 2) {
			Coordinate between = origin.betweenDiagonal(target);
			Piece eatenPiece = this.board.getPiece(between);
			if (eatenPiece == null || this.turn.isColor(eatenPiece.getColor())) {
				return Error.BAD_EATING;
			}
			this.board.remove(between);
		}
		this.board.move(origin, target);
		this.turn.change();
		return null;
	}

	public Color getColor() {
		return turn.getColor();
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.board.getPiece(coordinate);
	}

	public Board getBoard() {
		return this.board;
	}

	@Override
	public String toString() {
		return this.board + "\n" + this.turn;
	}

	public boolean isFinished() {
		// TODO: if no more moves are allowed for current color, then return false.
		return false;
	}
}