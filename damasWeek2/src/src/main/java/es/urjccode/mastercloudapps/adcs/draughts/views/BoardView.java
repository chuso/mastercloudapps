package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.models.Board;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public class BoardView {

    Console console;

    public BoardView() {
        console = new Console();
    }

    public void writeln(Board board) {
        console.writeln(board.toString());
    }
}
