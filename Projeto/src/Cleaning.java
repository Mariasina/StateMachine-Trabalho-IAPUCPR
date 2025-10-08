public class Cleaning extends AbstractState<Manny> {
    public Cleaning(Manny manny) {
        super(manny);
    }

    @Override
    public void enter() {
        character.printStats("Começando a limpar o estúdio...");
    }

    @Override
    public void execute() {
        int clean = character.getCleanTime();
        character.printStats(": Limpando...");
        character.printStats(" | Sujeira: " + character.getCleanTime());

        character.setCleanTime(clean - 1);

        if (clean <= 0) {
            character.printStats("Tudo limpo!");
            character.setRestTime((int)(Math.random() * 3) + 10);
            character.setState(new Resting(character, true));
        }
    }
}
