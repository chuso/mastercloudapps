package es.urjccode.mastercloudapps.adcs.draughts;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.Logic;
import es.urjccode.mastercloudapps.adcs.draughts.views.ConsoleView;

public class Draughts {

    private Logic logic;
    private ConsoleView view;

    private Draughts() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    public static void main(String[] args) {
        new Draughts().play();
    }

    public void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }

}
