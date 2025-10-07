public class Showering extends AbstractState<Jonas>{

    public Showering(Jonas jonas){
        super(jonas);
    }

    @Override
    public void enter() {
        character.printStats(character.getName() + ": Hora de tomar banho!");
    }

    @Override
    public void leave() {
        character.printStats(character.getName() + ": Já estou limpo!");
    }

    @Override
    public void execute() {
        character.printStats(character.getName() + ": Tomando banho...");
        character.addDirty(-5);

        if (character.getDirty() <= 0) {
            character.setState(new Playing(character));
        }
    }
}
