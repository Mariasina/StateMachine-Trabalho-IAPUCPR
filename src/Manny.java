public class Manny implements Agente {
    private int paintCount = 0;
    private int restTime = 0;
    private int cleanTime = 0;
    private String name = "Manny";
    private State<Manny> state;

    public Manny() {
        this.state = new Painting(this);
        state.enter();
    }

    public String getName() { return name; }

    public int getPaintCount() { return paintCount; }
    public void addPaint(int value) { this.paintCount += value; }

    public int getRestTime() { return restTime; }
    public void setRestTime(int restTime) { this.restTime = restTime; }

    public int getCleanTime() { return cleanTime; }
    public void setCleanTime(int cleanTime) { this.cleanTime = cleanTime; }

    @Override
    public void update() {
        state.execute();
    }

    @Override
    public void printStats(String status) {
        System.out.println(name + " - " + status);
    }

    public void setState(State<Manny> newState) {
        state.exit();
        this.state = newState;
        state.enter();
    }
}