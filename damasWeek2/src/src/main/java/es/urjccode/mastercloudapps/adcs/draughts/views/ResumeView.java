package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;
import es.urjccode.mastercloudapps.adcs.draughts.utils.YesNoDialog;

public class ResumeView {

    private ResumeController resumeController;
    private Console console;
    private YesNoDialog yesNoDialog;
    private BoardView boardView;

    public ResumeView(ResumeController resumeController){
        this.resumeController = resumeController;
        this.console = new Console();
        this.yesNoDialog = new YesNoDialog();
        this.boardView = new BoardView();
    }

    public void interact() {
        boardView.writeln(resumeController.getBoard());
        console.writeln(Message.FINISHED);
        resumeController.resume(yesNoDialog.read(Message.RESUME));
    }

}
