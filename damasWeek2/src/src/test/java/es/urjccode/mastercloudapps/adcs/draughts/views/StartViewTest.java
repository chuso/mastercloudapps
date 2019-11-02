package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;
import es.urjccode.mastercloudapps.adcs.draughts.utils.YesNoDialog;

@RunWith(MockitoJUnitRunner.class)
public class StartViewTest {

    @Mock
    StartController startController;

    @Mock
    Console console;

    @Mock
    YesNoDialog yesNoDialog;

    @Mock
    BoardView BoardView;

    @InjectMocks
    StartView startView;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenStartViewWhenInteractThenNoError() {
        startView.writeln();
        verify(console).writeln(Message.START);
        verify(startController).start();
    }

}
