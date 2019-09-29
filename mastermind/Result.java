package mastermind;

public class Result {

    private int deads;
    private int damaged;
    private int size;

    public Result(int deads, int damaged, int size) {
        this.deads = deads;
        this.damaged = damaged;
        this.size = size;
    }

    public void write() {
        System.out.println(deads + " blacks and " + damaged + " whites");
    }

    public boolean isWinner() {
        return deads == size;
    }

}
