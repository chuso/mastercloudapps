package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;
import es.urjccode.mastercloudapps.adcs.draughts.utils.YesNoDialog;

@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {

    @Mock
    ResumeController resumeController;

    @Mock
    Console console;

    @Mock
    YesNoDialog yesNoDialog;

    @Mock
    BoardView BoardView;

    @InjectMocks
    ResumeView resumeView;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenResumeViewWhenInteractThenValueIsSetToController() {
        boolean resume = false;
        when(yesNoDialog.read(Message.RESUME)).thenReturn(resume);
        resumeView.interact();
        verify(console).writeln(Message.FINISHED);
        verify(resumeController).resume(resume);
    }

}
