package mastermindWeek3.santaTecla.utils;

import java.util.ArrayList;

public abstract class Menu {

    private static final String OPTION = "----- Choose one option ----";
    private Console console;
    private ArrayList<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList<Command>();
        this.console = new Console();
    }

    public void execute() {
        ArrayList<Command> commands = new ArrayList<Command>();
        for (int i = 0; i < this.commandList.size(); i++) {
            if (this.commandList.get(i).isActive()) {
                commands.add(this.commandList.get(i));
            }
        }
        boolean error;
        int option;
        do {
            error = false;
            console.writeln();
            console.writeln(OPTION);
            for (int i = 0; i < commands.size(); i++) {
                console.writeln((i + 1) + ") " + commands.get(i).getTitle());
            }
            option = console.readInt("") - 1;
            if (!new ClosedInterval(0, commands.size() - 1).includes(option)) {
                error = true;
            }
            console.writeln();
        } while (error);
        commands.get(option).execute();
    }

    protected void addCommand(Command command) {
        this.commandList.add(command);
    }

}
