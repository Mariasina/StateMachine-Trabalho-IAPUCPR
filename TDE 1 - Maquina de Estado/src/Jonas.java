public class Jonas implements Agente {
    private int dirty = 0;
    private final String name = "Jonas";
    private State<? extends Agente> state;

    public Jonas() {
        this.state = new Playing(this);
        state.enter();
    }

    public String getName() {
        return name;
    }

    public int getDirty() {
        return dirty;
    }

    public void addDirty(int value) {
        this.dirty = Math.max(this.dirty + value, 0);
    }

    @Override
    public void printStats(String stats) {
        System.out.println(stats);
        System.out.println(name + " | Sujeira: " + dirty);
        System.out.println();
    }

    @Override
    public void update() {
        state.execute();
    }

    public void setState(State<? extends Agente> newState) {
        state.exit();
        this.state = newState;
        state.enter();
    }
}
