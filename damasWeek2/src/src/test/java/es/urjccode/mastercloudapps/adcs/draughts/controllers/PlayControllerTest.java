package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;

public class PlayControllerTest {

    @Mock
    private Game game;

    @Mock
    private State state;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenPlayControllerWhenMovementIsCorrectThenNotError() {
        Coordinate origin = mock(Coordinate.class);
        Coordinate target = mock(Coordinate.class);
        when(game.isFinished()).thenReturn(false);
        when(game.move(origin, target)).thenReturn(null);
        PlayController playController = new PlayController(game, state);
        assertNull(playController.move(origin, target));
        verifyZeroInteractions(state);
    }

    @Test
    public void givenPlayControllerWhenMovementIsNotCorrectThenError() {
        Error returnedError = Error.BAD_DISTANCE;
        Coordinate origin = mock(Coordinate.class);
        Coordinate target = mock(Coordinate.class);
        when(game.isFinished()).thenReturn(false);
        when(game.move(origin, target)).thenReturn(returnedError);
        PlayController playController = new PlayController(game, state);
        assertEquals(returnedError, playController.move(origin, target));
        verifyZeroInteractions(state);
    }

    @Test
    public void givenPlayControllerWhenGameIsFinishedThenChangeState() {
        Coordinate origin = mock(Coordinate.class);
        Coordinate target = mock(Coordinate.class);
        when(game.isFinished()).thenReturn(true);
        when(game.move(origin, target)).thenReturn(null);
        PlayController playController = new PlayController(game, state);
        assertNull(playController.move(origin, target));
        verify(state).next();
    }

}
