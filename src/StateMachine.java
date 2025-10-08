import java.util.ArrayList;
import java.util.List;

public class StateMachine {
    private final List<Agente> agents = new ArrayList<>();

    public void addAgent(Agente agent) {
        agents.add(agent);
    }

    public void run(int ticks) {
        for (int i = 0; i < ticks; i++) {
            System.out.println("---- Tick " + (i + 1) + " ----");
            for (Agente agent : agents) {
                agent.update();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
