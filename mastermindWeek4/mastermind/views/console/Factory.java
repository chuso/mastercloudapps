package mastermind.views.console;

public class Factory implements mastermind.views.Factory {

    @Override
    public StartView buildStartView() {
        return new StartView();
    }

    @Override
    public ProposalView buildProposalView() {
        return new ProposalView();
    }

    @Override
    public ResumeView buildResumeView() {
        return new ResumeView();
    }

}
