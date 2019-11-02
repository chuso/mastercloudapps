package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {

    @Test
    public void testGivenRow1AndColumnNegativeThenIsNotValid() {
        assertFalse(new Coordinate(1, -1).isValid());
    }

    @Test
    public void testGivenRow1AndColumn8ThenIsNotValid() {
        assertFalse(new Coordinate(1, 8).isValid());
    }

    @Test
    public void testGivenNegativeRowAndColumn1ThenIsNotValid() {
        assertFalse(new Coordinate(-1, 1).isValid());
    }

    @Test
    public void testGivenRow8AndColumn1ThenIsNotValid() {
        assertFalse(new Coordinate(8, 1).isValid());
    }

    @Test
    public void testGivenRow1AndColumn1ThenIsValid() {
        assertTrue(new Coordinate(1, 1).isValid());
    }

    @Test
    public void testGivenACoordinateWhenIsDiagonalUpThenFalse() {
        assertFalse(new Coordinate(5, 6).isDiagonal(new Coordinate(4, 6)));
    }

    @Test
    public void testGivenACoordinateWhenIsDiagonalDownThenFalse() {
        assertFalse(new Coordinate(5, 6).isDiagonal(new Coordinate(6, 6)));
    }

    @Test
    public void testGivenACoordinateWhenIsDiagonalLeftThenFalse() {
        assertFalse(new Coordinate(5, 6).isDiagonal(new Coordinate(5, 5)));
    }

    @Test
    public void testGivenACoordinateWhenIsDiagonalRightThenFalse() {
        assertFalse(new Coordinate(5, 6).isDiagonal(new Coordinate(5, 7)));
    }

    @Test
    public void testGivenACoordinateWhenIsDiagonalUpRightThenTrue() {
        assertTrue(new Coordinate(5, 6).isDiagonal(new Coordinate(4, 7)));
    }

    @Test
    public void testGivenACoordinateWhenIsDiagonalUpLeftThenTrue() {
        assertTrue(new Coordinate(5, 6).isDiagonal(new Coordinate(4, 5)));
    }

    @Test
    public void testGivenACoordinateWhenIsDiagonalDownRightThenTrue() {
        assertTrue(new Coordinate(5, 6).isDiagonal(new Coordinate(6, 7)));
    }

    @Test
    public void testGivenACoordinateWhenIsDiagonalDownLeftThenTrue() {
        assertTrue(new Coordinate(5, 6).isDiagonal(new Coordinate(6, 5)));
    }

    @Test(expected = AssertionError.class)
    public void testGivenACoordinateWhenIsDiagonalNullThenException() {
        new Coordinate(5, 6).isDiagonal(null);
    }

    @Test
    public void testGivenACoordinate1and1AndACoordinate3and3WhenDiagonalDistanceThen2() {
        assertEquals(2, new Coordinate(1, 1).diagonalDistance(new Coordinate(3, 3)));
    }

    @Test
    public void testGivenACoordinate1and1AndACoordinateMinus2andMinus2WhenDiagonalDistanceThen3() {
        assertEquals(3, new Coordinate(1, 1).diagonalDistance(new Coordinate(-2, -2)));
    }

    @Test(expected = AssertionError.class)
    public void testGivenACoordinate1and1AndNullWhenDiagonalDistanceThenException() {
        new Coordinate(1, 1).diagonalDistance(null);
    }

    @Test
    public void testGivenACoordinate3and3AndACoordinate5and5WhenBetweenDiagonalThen4and4() {
        assertEquals(new Coordinate(4, 4), new Coordinate(3, 3).betweenDiagonal(new Coordinate(5, 5)));
    }

    @Test
    public void testGivenACoordinate3and3AndACoordinate1and5WhenBetweenDiagonalThen2and4() {
        assertEquals(new Coordinate(2, 4), new Coordinate(3, 3).betweenDiagonal(new Coordinate(1, 5)));
    }

    @Test
    public void testGivenACoordinate3and3AndACoordinate1and1WhenBetweenDiagonalThen2and2() {
        assertEquals(new Coordinate(2, 2), new Coordinate(3, 3).betweenDiagonal(new Coordinate(1, 1)));
    }

    @Test
    public void testGivenACoordinate3and3AndACoordinate5and1WhenBetweenDiagonalThen4and2() {
        assertEquals(new Coordinate(4, 2), new Coordinate(3, 3).betweenDiagonal(new Coordinate(5, 1)));
    }

    @Test(expected = AssertionError.class)
    public void testGivenACoordinate3and3AndNullWhenBetweenDiagonalThenException() {
        new Coordinate(3, 3).betweenDiagonal(null);
    }

    @Test
    public void testGivenABlackCoordinateWhenIsBlackThenTrue() {
        assertTrue(new Coordinate(2, 3).isBlack());
    }

    @Test
    public void testGivenAWhiteCoordinateWhenIsBlackThenFalse() {
        assertFalse(new Coordinate(3, 3).isBlack());
    }

    @Test
    public void testGivenACoordianteWhenToStringThenOk() {
        assertEquals("(3, 4)", new Coordinate(3, 4).toString());
    }

}