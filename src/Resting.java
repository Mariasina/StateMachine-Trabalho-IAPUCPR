public class Resting extends AbstractState<Manny> {
    private boolean afterCleaning;

    public Resting(Manny manny, boolean afterCleaning) {
        super(manny);
        this.afterCleaning = afterCleaning;
    }

    @Override
    public void enter() {
        character.printStats("Indo descansar...");
    }

    @Override
    public void execute() {
        int rest = character.getRestTime();
        character.printStats(character.getName() + ": Descansando...");
        character.printStats(character.getName() + " | Tempo restante: " + character.getRestTime());
        character.setRestTime(rest - 1);

        if (rest <= 0) {
            if (afterCleaning) {

                character.addPaint(-character.getPaintCount());
            }
            character.printStats("Pronto para voltar a pintar!");
            character.setState(new Painting(character));
        }
    }
}