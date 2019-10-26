package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.SaveController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;
import mastermindWeek3.santaTecla.utils.YesNoDialog;

class SaveView extends WithConsoleView {

    private SaveController saveController;

    SaveView(SaveController saveController) {
        this.saveController = saveController;
    }

    void interact() {
        boolean save = new YesNoDialog().read(MessageView.SAVE.getMessage());
        String name = null;
        if (save) {
            if (saveController.hasName()) {
                saveController.save();
            } else {
                boolean exists = false;
                do {
                    name = this.console.readString(MessageView.NAME.getMessage());
                    exists = saveController.exists(name);
                    if (exists) {
                        this.console.writeln(MessageView.NAME_EXISTS.getMessage());
                    }
                } while (exists);
                saveController.save(name);
            }
        }
        saveController.next();
    }

}
