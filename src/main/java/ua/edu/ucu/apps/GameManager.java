package ua.edu.ucu.apps;

import java.io.PrintStream;

import lombok.Getter;
import lombok.Setter;
import ua.edu.ucu.apps.characters.Character;

@Getter
@Setter
public class GameManager {
    private PrintStream stream;

    GameManager(PrintStream stream) {
        this.stream = stream;
    }

    private void kick(Character c1, Character c2) {
        c1.kick(c2);
        stream.println(
                c1.getClass().getName()
                        + "(hp: " + c1.getHp()
                        + "; power: " + c1.getPower()
                        + ") kicked " + c2.getClass().getName()
                        + "(hp: " + c2.getHp()
                        + "; power: " + c2.getPower()
                        + ")");
    }

    public void fight(Character c1, Character c2) {
        fight(c1, c2, 64);
    }

    public void fight(Character c1, Character c2, int limit) {
        stream.println(
                c1.getClass().getName()
                        + "(hp: " + c1.getHp()
                        + "; power: " + c1.getPower()
                        + ") vs " + c2.getClass().getName()
                        + "(hp: " + c2.getHp()
                        + "; power: " + c2.getPower()
                        + ")");

        for (int round = 1; round <= limit; round++) {
            stream.println("\nRound " + round);

            kick(c1, c2);
            if (!c2.isAlive()) {
                stream.println("\n" + c2.getClass().getName() + " died");
                return;
            }

            kick(c2, c1);
            if (!c1.isAlive()) {
                stream.println("\n" + c1.getClass().getName() + " died");
                return;
            }
        }

        stream.println("\nRun out of time");
    }
}
