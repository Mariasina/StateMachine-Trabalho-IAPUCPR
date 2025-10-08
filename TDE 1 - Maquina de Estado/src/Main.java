import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StateMachine machine = new StateMachine();
        Jonas jonas = new Jonas();
        machine.addAgent(jonas);
        machine.run();
    }
}