public class Painting extends AbstractState<Manny> {
    public Painting(Manny manny) {
        super(manny);
    }

    @Override
    public void enter() {
        character.printStats("Hora de pintar!");
    }

    @Override
    public void execute() {
        character.printStats(": Pintando...");
        character.printStats(" | Quadros: " + character.getPaintCount());
        character.addPaint(1);

        int count = character.getPaintCount();

        if (count == 2) {
            character.setRestTime((int)(Math.random() * 4) + 7);
            character.setState(new Resting(character, false));
        }


        if (count == 3) {
            character.setCleanTime((int)(Math.random() * 6) + 10);
            character.setState(new Cleaning(character));
        }
    }
}
