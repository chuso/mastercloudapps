package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public class StartView {

    StartController startController;
    Console console;

    public StartView(StartController startController) {
        this.startController = startController;
        console = new Console();
    }

    public void writeln() {
        startController.start();
        console.writeln(Message.START);
    }

}
