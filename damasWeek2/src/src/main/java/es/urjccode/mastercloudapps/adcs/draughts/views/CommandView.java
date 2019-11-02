package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView {

    private Console console;

    private PlayController playController;

    private BoardView boardView;

    private static final String[] COLORS = {"blancas", "negras"};

    public CommandView(PlayController playController) {
        this.playController = playController;
        this.console = new Console();
        this.boardView = new BoardView();
    }

    public void interact() {
        boardView.writeln(playController.getBoard());
        String color = CommandView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            if (!command.matches("\\d\\d\\.\\d\\d")) {
                error = Error.INVALID_INPUT;
            } else {
                int origin = Integer.parseInt(command.substring(0, 2));
                int target = Integer.parseInt(command.substring(3, 5));
                error = playController.move(new Coordinate(origin/10, origin%10), new Coordinate(target/10, target%10));
            }
            if (error != null){
                console.writeln("Error!!! " + new ErrorView(error).getMessage());
            }
        } while (error != null);
    }

}