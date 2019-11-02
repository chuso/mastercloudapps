package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SquareTest {

    @Test
    public void testGivenAnEmptySquareWhenIsEmptyThenTrue() {
        Square square = new Square();
        assertTrue(square.isEmpty());
    }

    @Test
    public void testGivenAnEmptySquareWhenGetColorThenNull() {
        Square square = new Square();
        assertNull(square.getColor());
    }

    @Test
    public void testGivenANonEmptySquareWhenIsEmptyThenFalse() {
        Square square = new Square();
        square.put(new Piece(Color.BLACK));
        assertFalse(square.isEmpty());
    }

    @Test
    public void testGivenANonEmptySquareWhenGetColorThenColorReturned() {
        Square square = new Square();
        square.put(new Piece(Color.BLACK));
        assertEquals(Color.BLACK, square.getColor());
    }

    @Test
    public void testGivenANonEmptySquareWhenRemoveThenIsEmpty() {
        Square square = new Square();
        square.put(new Piece(Color.BLACK));
        square.remove();
        assertTrue(square.isEmpty());
    }

    @Test
    public void testGivenANonEmptySquareWhenPutNullThenIsEmpty() {
        Square square = new Square();
        square.put(new Piece(Color.BLACK));
        square.put(null);
        assertTrue(square.isEmpty());
    }
}
