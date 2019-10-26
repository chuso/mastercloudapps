package mastermindWeek3.mastermind.distributed.dispatchers;

public enum FrameType {
    START,
    STATE,
    UNDO,
    REDO,
    UNDOABLE,
    REDOABLE,
    NEW_GAME,
    CLOSE,
    ADDPROPOSEDCOMBINATION,
    ISLOSER,
    ISWINNER,
    GETATTEMPTS,
    GETCOLORS,
    GETBLACKS,
    GETWHITES,
    GETWIDTH;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}
