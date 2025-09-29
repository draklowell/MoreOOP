package ua.edu.ucu.apps.characters;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ua.edu.ucu.apps.kickstrategies.HumanStrategy;

public class King extends Character {
    public King() {
        this(ThreadLocalRandom.current());
    }

    public King(Random random) {
        super(
                random.nextInt(5, 16),
                random.nextInt(5, 16),
                new HumanStrategy(random));
    }
}
