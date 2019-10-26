package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.controllers.Logic;
import mastermindWeek3.mastermind.distributed.dispatchers.*;
import mastermindWeek3.mastermind.models.StateValue;

public class LogicServer extends Logic {

    public LogicServer() {
        super(true);
    }

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.controllers.get(StateValue.INITIAL)));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.controllers.get(StateValue.FINAL)));
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
    }

}
