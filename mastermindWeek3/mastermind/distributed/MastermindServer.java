package mastermindWeek3.mastermind.distributed;

import mastermindWeek3.mastermind.distributed.dispatchers.DispatcherPrototype;

public class MastermindServer {

    private DispatcherPrototype dispatcherPrototype;

    private LogicServer logicServer;

    private MastermindServer() {
        this.dispatcherPrototype = new DispatcherPrototype();
        this.logicServer = new LogicServer();
        this.logicServer.createDispatchers(this.dispatcherPrototype);
    }

    public static void main(String[] args) {
        new MastermindServer().serve();
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }

}
