import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StateMachine machine = new StateMachine();
        Jonas jonas = new Jonas();
        Manny manny = new Manny();
        machine.addAgent(jonas);
        machine.addAgent(manny);
        machine.run();
    }
}