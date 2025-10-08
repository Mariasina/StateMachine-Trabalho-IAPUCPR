import java.util.ArrayList;
import java.util.List;

public class StateMachine {
    private final List<Agente> agents = new ArrayList<>();

    public void addAgent(Agente agent) {
        agents.add(agent);
    }

    public void run() {
        while (true) {
            for (Agente agent : agents) {
                agent.update();
            }
            System.out.println("----");
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
