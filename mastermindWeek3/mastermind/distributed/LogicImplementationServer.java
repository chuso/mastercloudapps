package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.controllers.implementation.LogicImplementation;
import mastermindWeek3.mastermind.distributed.dispatchers.*;
import mastermindWeek3.mastermind.models.StateValue;

public class LogicImplementationServer extends LogicImplementation {

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.controllers.get(StateValue.INITIAL)));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.controllers.get(StateValue.FINAL)));
        dispatcherPrototype.add(FrameType.STARTNAME, new StartNameDispatcher(this.controllers.get(StateValue.INITIAL)));
        dispatcherPrototype.add(FrameType.TITLES, new TitlesDispatcher(this.controllers.get(StateValue.INITIAL)));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.controllers.get(StateValue.IN_GAME)));

        dispatcherPrototype.add(FrameType.ADDPROPOSEDCOMBINATION, new AddProposedCombinationDispatcher(this.controllers.get(StateValue.IN_GAME)));

        dispatcherPrototype.add(FrameType.ISLOSER, new IsLoserDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.ISWINNER, new IsWinnerDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.GETATTEMPTS, new GetAttemptsDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.GETCOLORS, new GetColorsDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.GETBLACKS, new GetBlacksDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.GETWHITES, new GetWhitesDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.GETWIDTH, new GetWidthDispatcher(this.controllers.get(StateValue.IN_GAME)));

        dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.controllers.get(StateValue.IN_GAME)));
        dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.controllers.get(StateValue.SAVING)));
        dispatcherPrototype.add(FrameType.SAVENAMED, new SaveNamedDispatcher(this.controllers.get(StateValue.SAVING)));
        dispatcherPrototype.add(FrameType.HASNAME, new HasNameDispatcher(this.controllers.get(StateValue.SAVING)));
        dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.controllers.get(StateValue.SAVING)));
        dispatcherPrototype.add(FrameType.GETTITLE, new GetTitleDispatcher(this.controllers.get(StateValue.SAVING)));
        dispatcherPrototype.add(FrameType.SETTITLE, new SetTitleDispatcher(this.controllers.get(StateValue.SAVING)));
    }

}
