public interface Agente {
    void update();
    void setState(State<?> state);
    void printStats(String stateName);
}
