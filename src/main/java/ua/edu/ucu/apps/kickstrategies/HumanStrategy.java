package ua.edu.ucu.apps.kickstrategies;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ua.edu.ucu.apps.characters.Character;

public class HumanStrategy implements KickStrategy {
    Random random;

    public HumanStrategy() {
        this(ThreadLocalRandom.current());
    }

    public HumanStrategy(Random random) {
        this.random = random;
    }

    @Override
    public void kick(Character kicker, Character kicked) {
        int damage = random.nextInt(kicker.getPower() + 1);
        kicked.setHp(kicked.getHp() - damage);
    }
}
