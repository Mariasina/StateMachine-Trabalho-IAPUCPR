import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList<>();

        characters.add(new Juca());
        characters.add(new Jonas());

        while(true) {
            for(Character character: characters){
                character.update();
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
