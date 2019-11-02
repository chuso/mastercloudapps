package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;

public class ResumeControllerTest {

    @Mock
    private Game game;

    @Mock
    private State state;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenResumeControllerWhenResumeTrueThenReset() {
        ResumeController resumeController = new ResumeController(game, state);
        resumeController.resume(true);
        verify(game).clear();
        verify(state).reset();
        verify(state, times(0)).next();
    }

    @Test
    public void givenResumeControllerWhenResumeFalseThenFinish() {
        ResumeController resumeController = new ResumeController(game, state);
        resumeController.resume(false);
        verifyZeroInteractions(game);
        verify(state).next();
    }

}
