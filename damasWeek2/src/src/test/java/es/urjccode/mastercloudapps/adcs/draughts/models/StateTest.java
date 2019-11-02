package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;


import org.junit.Test;

public class StateTest {

    @Test
    public void testGivenStateWhenGetValueThenInitial() {
        State state = new State();
        assertThat(state.getValueState(), is(equalTo(StateValue.INITIAL)));
    }

    @Test
    public void testGivenInitialStateWhenNextThenInOpenedGame() {
        State state = new State();
        state.next();
        assertThat(state.getValueState(), is(equalTo(StateValue.OPENED_GAME)));
    }

    @Test
    public void testGivenOpenedGameWhenNextThenFinal() {
        State state = new State();
        state.next();
        state.next();
        assertThat(state.getValueState(), is(equalTo(StateValue.FINAL)));
    }

    @Test
    public void testGivenOpenedGameWhenResetThenInitial() {
        State state = new State();
        state.next();
        state.reset();
        assertThat(state.getValueState(), is(equalTo(StateValue.INITIAL)));
    }

    @Test
    public void testGivenFinalGameWhenNextThenExit() {
        State state = new State();
        state.next();
        state.next();
        state.next();
        assertThat(state.getValueState(), is(equalTo(StateValue.EXIT)));
    }

}
