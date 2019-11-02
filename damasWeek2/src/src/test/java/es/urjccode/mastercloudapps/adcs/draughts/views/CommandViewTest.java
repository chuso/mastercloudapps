package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class CommandViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @Mock
    BoardView boardView;

    @InjectMocks
    CommandView commandView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenCommandViewWhenInteractThenBoardIsDisplayed() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(anyString())).thenReturn("21.30");
        commandView.interact();
        verify(boardView).writeln(any());
    }

    @Test
    public void testGivenCommandViewInBlackWhenInteractThenBlackIsDisplayed() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(anyString())).thenReturn("21.30");
        commandView.interact();
        verify(console).readString("Mueven las negras: ");
    }

    @Test
    public void testGivenCommandViewWhenInteractWithInvalidInputThenError() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(anyString())).thenReturn("2130").thenReturn("21.30");
        commandView.interact();
        verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
        verify(console, times(2)).readString(anyString());
        verify(console).writeln("Error!!! No te entiendo: <d><d>{,<d><d>}[0-2]");
    }

    @Test
    public void testGivenCommandViewWhenInteractNotDiagonalThenError() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(anyString())).thenReturn("21.31").thenReturn("21.30");
        when(playController.move(any(), any())).thenReturn(Error.NOT_DIAGONAL).thenReturn(null);
        commandView.interact();
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 1));
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
        verify(console, times(2)).readString(anyString());
        verify(console).writeln("Error!!! No vas en diagonal");
    }

    @Test
    public void testGivenCommandViewWhenValidInputThenNoError() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(any())).thenReturn("21.30");
        commandView.interact();
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
        verify(console).readString("Mueven las negras: ");
        verify(console, times(0)).writeln(anyString());
    }

}
