package ua.edu.ucu.apps.characters;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ua.edu.ucu.apps.kickstrategies.HumanStrategy;

public class Knight extends Character {
    public Knight() {
        this(ThreadLocalRandom.current());
    }

    public Knight(Random random) {
        super(
                random.nextInt(2, 13),
                random.nextInt(2, 13),
                new HumanStrategy(random));
    }
}
