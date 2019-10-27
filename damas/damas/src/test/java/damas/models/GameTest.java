package damas.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import damas.models.Game;
import damas.models.Coordinate;
import damas.models.Piece;
import damas.models.Color;
import damas.types.Error;

public class GameTest {

    public GameTest() {

    }

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(game.move(origin, target));
        assertNull(game.getPiece(origin));
        Piece pieceTarget = game.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
    public void givenPlayControllerWhenTwoJumpsThenNotError() {
        Game game = new Game();
        String boardString = " b      "
                           + "  n     "
                           + "        "
                           + "  n     "
                           + "        "
                           + "    n   "
                           + "        "
                           + "        ";
        game.loadFromString(boardString, new Turn(Color.WHITE));
        Error error = game.move(
            new Coordinate(0, 1),
            new Coordinate(2, 3),
            new Coordinate(4, 1)
        );
        assertNull(error);
    }

    @Test
    public void givenPlayNoMoreMovesThenFinished() {
        Game game = new Game();
        String boardString = "n n     "
                           + " b      "
                           + "        "
                           + "        "
                           + "        "
                           + "        "
                           + "        "
                           + "        ";
        game.loadFromString(boardString, new Turn(Color.WHITE));
        assertTrue(game.isGameFinished());
    }

    @Test
    public void givenPlayNoMorePiecesThenFinished() {
        Game game = new Game();
        String boardString = "n       "
                           + "   n    "
                           + "        "
                           + " b      "
                           + "        "
                           + "        "
                           + "        "
                           + "        ";
        game.loadFromString(boardString, new Turn(Color.WHITE));
        game.move(new Coordinate(3,1), new Coordinate(2, 2));
        assertFalse(game.isGameFinished());
        game.move(new Coordinate(1,3), new Coordinate(3, 2));
        assertTrue(game.isGameFinished());
    }

    @Test
    public void givenPlayMoveToEndThenNewDama() {
        Game game = new Game();
        String boardString = "        "
                           + "        "
                           + " n      "
                           + "n b     "
                           + "        "
                           + "        "
                           + " b      "
                           + "        ";
        game.loadFromString(boardString, new Turn(Color.WHITE));
        Coordinate origin = new Coordinate(7, 2);
        Coordinate target = new Coordinate(8, 3);
        assertFalse(game.getPiece(origin) instanceof Dama);
        game.move(origin, target);
        assertTrue(game.getPiece(target) instanceof Dama);
    }

    @Test
    public void givenPlayControllerWhenMoveToSamePositionThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Error error = game.move(origin, origin);
        assertNotNull(error);
        assertEquals(error, Error.NOT_MOVING_FORWARD);
    }

    @Test
    public void givenPlayControllerWhenNoPieceToMoveThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(4, 0);
        Coordinate target = new Coordinate(3, 1);
        Error error = game.move(origin, target);
        assertNotNull(error);
        assertEquals(error, Error.NO_PIECE);
        assertNull(game.getPiece(origin));
    }

    @Test
    public void givenPlayControllerWhenBlackStartsThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        Error error = game.move(origin, target);
        assertNotNull(error);
        assertEquals(error, Error.INVALID_USER);
        assertNotEquals(game.getPiece(origin).getColor(), Color.WHITE);
    }

    @Test
    public void givenPlayControllerWhenMovementNotDiagonalThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 0);
        Error error = game.move(origin, target);
        assertNotNull(error);
        assertEquals(error, Error.NOT_DIAGONAL);
    }

    @Test
    public void givenPlayControllerWhenMovementToNotEmptyThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(6, 1);
        Coordinate target = new Coordinate(5, 2);
        Error error = game.move(origin, target);
        assertNotNull(error);
        assertEquals(error, Error.NOT_EMPTY_TARGET);
    }

    @Test
    public void givenPlayControllerWhenCapturingOwnThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(6, 1);
        Coordinate target = new Coordinate(4, 3);
        Error error = game.move(origin, target);
        assertNotNull(error);
        assertEquals(error, Error.INVALID_CAPTURED);
    }

    @Test
    public void givenPlayControllerWhenInvalidDistanceInMoveThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(3, 2);
        Error error = game.move(origin, target);
        assertNotNull(error);
        assertEquals(error, Error.INVALID_DISTANCE);
    }

    @Test
    public void givenPlayControllerWhenNotMovingForwardThenError() {
        Game game = new Game();
        game.move(new Coordinate(5, 0), new Coordinate(4, 1));
        game.move(new Coordinate(2, 7), new Coordinate(3, 6));
        Error error = game.move(new Coordinate(4, 1), new Coordinate(5, 0));
        assertNotNull(error);
        assertEquals(error, Error.NOT_MOVING_FORWARD);
    }

    @Test
    public void givenPlayControllerWhenTooManyCapturedThenError() {
        Game game = new Game();
        String boardString = " B      "
                           + "  n     "
                           + "        "
                           + "  n     "
                           + "        "
                           + "  n n   "
                           + "        "
                           + "        ";
        game.loadFromString(boardString, new Turn(Color.WHITE));
        Error error = game.move(
            new Coordinate(0, 1),
            new Coordinate(2, 3),
            new Coordinate(4, 1),
            new Coordinate(6, 3),
            new Coordinate(4, 5)
        );
        assertNotNull(error);
        assertEquals(error, Error.TOO_MANY_CAPTURED);
    }

}