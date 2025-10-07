public class Playing extends AbstractState<Jonas>{
    public Playing(Jonas jonas){
        super(jonas);
    }

    @Override
    public void enter() {
        character.printStats(character.getName() + ": Hora de jogar!");
    }

    @Override
    public void execute() {
        character.printStats(character.getName() + ": Jogando...");
        character.addDirty(5);

        if (character.getDirty() >= 30) {
            character.setState(new Showering(character));
        }
    }
}
