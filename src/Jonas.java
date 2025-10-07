public class Jonas implements Character {
    private int dirty = 0;
    private String name = "Jonas";

    private State<Jonas> state;

    public Jonas() {
        this.state = new Playing(this);
        this.state.enter();
    }

    public String getName() {
        return name;
    }

    public int getDirty() {
        return dirty;
    }

    public void addDirty(int dirty) {
        this.dirty += dirty;
        this.dirty = Math.max(this.dirty, 0);
    }

    @Override
    public void printStats(String stats) {
        System.out.println(stats);
        System.out.println(name + ": Sujo - " + dirty + "\n");
    }

    @Override
    public void setState(State state) {
        this.state.leave();
        this.state = state;
        state.enter();
    }

    @Override
    public void update() {
        state.execute();
    }


}
