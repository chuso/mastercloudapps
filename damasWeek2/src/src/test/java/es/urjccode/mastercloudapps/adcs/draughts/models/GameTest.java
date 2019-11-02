package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertNull;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void init(){
        game = new Game();
    }

    @Test()
    public void testGivenGameWhenMoveWithOuterCoordinateThenOutCoordinateError() {
        Coordinate[][] coordinates = new Coordinate[][] {
            { new Coordinate(5, 6), new Coordinate(4, 7) },
            { new Coordinate(2, 7), new Coordinate(3, 6) },
            { new Coordinate(4, 7), new Coordinate(3, 8) },
        };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test()
    public void testGivenGameWhenMoveWithOriginOuterCoordinateThenOutCoordinateError() {
        Error error = game.move(new Coordinate(3, 8), new Coordinate(4, 7));
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test()
    public void testGivenGameWhenMoveWithTargetOuterCoordinateThenOutCoordinateError() {
        Error error = game.move(new Coordinate(4, 7), new Coordinate(3, 8));
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test()
    public void testGivenGameWhenMoveFromEmptyCoordinateThenEmptyOriginError() {
        Error error = game.move(new Coordinate(0, 0), new Coordinate(1, 1));
        assertEquals(Error.EMPTY_ORIGIN, error);
    }

    @Test()
    public void testGivenGameWhenMoveFromOppositeColorThenOppositePieceError() {
        Error error = game.move(new Coordinate(2, 1), new Coordinate(3, 2));
        assertEquals(Error.OPPOSITE_PIECE, error);
    }

    @Test()
    public void testGivenGameWhenMoveNonDiagonalThenNotDiagonalError() {
        Error error = game.move(new Coordinate(5, 2), new Coordinate(4, 2));
        assertEquals(Error.NOT_DIAGONAL, error);
    }

    @Test()
    public void testGivenGameWhenMoveNonAdvanceThenNotAdvancedError() {
        Error error = game.move(new Coordinate(5, 2), new Coordinate(6, 3));
        assertEquals(Error.NOT_ADVANCED, error);
    }

    @Test()
    public void testGivenGameWhenMoveBadDistanceThenBadDistanceError() {
        Error error = game.move(new Coordinate(5, 2), new Coordinate(2, 5));
        assertEquals(Error.BAD_DISTANCE, error);
    }

    @Test()
    public void testGivenGameWhenMoveToNotEmptyTargetThenNotEmptyTargetError() {
        Error error = game.move(new Coordinate(7, 0), new Coordinate(6, 1));
        assertEquals(Error.NOT_EMPTY_TARGET, error);
    }

    @Test()
    public void testGivenGameWhenEatingEmptyThenBadEatingError() {
        Error error = game.move(new Coordinate(5, 0), new Coordinate(3, 2));
        assertEquals(Error.BAD_EATING, error);
    }

    @Test()
    public void testGivenGameWhenEatingCurrentUserPieceThenBadEatingError() {
        Error error = game.move(new Coordinate(6, 1), new Coordinate(4, 3));
        assertEquals(Error.BAD_EATING, error);
    }

    @Test
    public void testGivenGameWhenCorrectMovementThenOk() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        this.game.move(origin, target);
        assertNull(this.game.getPiece(origin));
        assertEquals(Color.WHITE, this.game.getPiece(target).getColor());
    }

    @Test
    public void testGivenGameWhenMovementThenEatPiece() {
        Coordinate[][] coordinates = new Coordinate[][] {
            { new Coordinate(5, 0), new Coordinate(4, 1) },
            { new Coordinate(2, 1), new Coordinate(3, 0) },
            { new Coordinate(5, 2), new Coordinate(4, 3) },
            { new Coordinate(3, 0), new Coordinate(5, 2) },
        };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertNull(error);
        assertNull(game.getPiece(new Coordinate(3, 0)));
        assertNull(game.getPiece(new Coordinate(4, 1)));
        assertEquals(Color.BLACK, game.getPiece(new Coordinate(5, 2)).getColor());
    }

}
