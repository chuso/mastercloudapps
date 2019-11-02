package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TurnTest {

    @Test
    public void testGivenNewTurnThenColorIsWhite() {
        Turn turn = new Turn();
        assertTrue(turn.isColor(Color.WHITE));
    }

    @Test
    public void testGivenNewTurnWhenChangeThenOk() {
        Turn turn = new Turn();
        turn.change();
        assertTrue(turn.isColor(Color.BLACK));
    }

}