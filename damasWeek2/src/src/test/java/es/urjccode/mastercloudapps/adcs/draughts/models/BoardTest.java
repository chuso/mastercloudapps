package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void prepareBoard() {
        this.board = new Board();
    }

    @Test
    public void testGivenNewBoardThenGoodLocations() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Color color = board.getColor(coordinate);
                if (coordinate.isBlack()){
                    assertEquals(Color.BLACK, color);
                } else {
                    assertNull(color);
                }
            }
        }
        for (int i = 5; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Color color = board.getColor(coordinate);
                if (coordinate.isBlack()){
                    assertEquals(Color.WHITE, color);
                } else {
                    assertNull(color);
                }
            }
        }
    }

    @Test(expected = NullPointerException.class)
    public void testGivenNewBoardWhenGetColorOfNullThenException() {
        board.getColor(null);
    }
    
    @Test
    public void testGivenNewBoardWhenGetColorOfBlackThenBlack() {
        assertEquals(Color.BLACK, board.getColor(new Coordinate(0, 1)));
    }

    @Test
    public void testGivenNewBoardWhenGetColorOfWhiteThenWhite() {
        assertEquals(Color.WHITE, board.getColor(new Coordinate(6, 1)));
    }

    @Test
    public void testGivenNewBoardWhenGetColorOfEmptyThenNull() {
        assertNull(board.getColor(new Coordinate(1, 1)));
    }

    @Test
    public void testGivenNewBoardWhenIsEmptyOfNonEmptyThenFalse() {
        assertFalse(board.isEmpty(new Coordinate(6, 1)));
    }

    @Test
    public void testGivenNewBoardWhenIsEmptyOfEmptyThenTrue() {
        assertTrue(board.isEmpty(new Coordinate(1, 1)));
    }

    @Test
    public void testGivenNewBoardWhenMoveFromNonEmptyToEmptyThenOk() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(4, 1);
        Piece piece = board.getPiece(origin);
        board.move(origin, target);
        assertTrue(board.isEmpty(origin));
        assertEquals(piece, board.getPiece(target));
    }

    @Test
    public void testGivenNewBoardWhenMoveFromNonEmptyToNonEmptyThenOk() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(0, 1);
        Piece piece = board.getPiece(origin);
        board.move(origin, target);
        assertTrue(board.isEmpty(origin));
        assertEquals(piece, board.getPiece(target));
    }

    @Test(expected = NullPointerException.class)
    public void testGivenNewBoardWhenMoveFromNullToCoordinateThenException() {
        Coordinate origin = null;
        Coordinate target = new Coordinate(0, 1);
        board.move(origin, target);
    }

    @Test(expected = NullPointerException.class)
    public void testGivenNewBoardWhenMoveFromCoordinateToNullThenException() {
        Coordinate origin = new Coordinate(0, 1);
        Coordinate target = null;
        board.move(origin, target);
    }

    @Test
    public void testGivenNewBoardWhenRemoveNonEmptyThenIsEmpty() {
        Coordinate coordinate = new Coordinate(2, 1);
        board.remove(coordinate);
        assertTrue(board.isEmpty(coordinate));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewBoardWhenRemoveNullThenException() {
        board.remove(null);
    }

    @Test
    public void testGivenNewBoardWhenToStringThenOk() {
        String string = " 01234567\n"
                      + "0 n n n n0\n"
                      + "1n n n n 1\n"
                      + "2 n n n n2\n"
                      + "3        3\n"
                      + "4        4\n"
                      + "5b b b b 5\n"
                      + "6 b b b b6\n"
                      + "7b b b b 7\n"
                      + " 01234567";
        assertEquals(string, board.toString());
    }

}