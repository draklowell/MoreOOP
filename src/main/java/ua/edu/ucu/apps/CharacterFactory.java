package ua.edu.ucu.apps;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.reflections.Reflections;

import lombok.SneakyThrows;
import ua.edu.ucu.apps.characters.Character;

public class CharacterFactory {
    private static final Reflections reflections = new Reflections("ua.edu.ucu.apps.characters");
    private static List<Constructor<? extends Character>> constructors;
    private static List<Boolean> hasArgument;
    Random random;

    public CharacterFactory() {
        this(ThreadLocalRandom.current());
    }

    public CharacterFactory(Random random) {
        this.random = random;
    }

    private static void extractCharacters() {
        Set<Class<? extends Character>> set = reflections.getSubTypesOf(Character.class);
        constructors = new ArrayList<>(set.size());
        hasArgument = new ArrayList<>(set.size());

        for (Class<? extends Character> current : set) {
            if (Modifier.isAbstract(current.getModifiers())) {
                continue;
            }

            try {
                Constructor<? extends Character> constructor = current.getConstructor(Random.class);
                constructors.add(constructor);
                hasArgument.add(true);
                continue;
            } catch (NoSuchMethodException e) {
            }

            try {
                Constructor<? extends Character> constructor = current.getConstructor();
                constructors.add(constructor);
                hasArgument.add(false);
            } catch (NoSuchMethodException e) {
                continue;
            }
        }
    }

    @SneakyThrows
    public Character createCharacter() {
        if (constructors == null) {
            extractCharacters();
        }

        int choice = random.nextInt(constructors.size());
        Constructor<? extends Character> constructor = constructors.get(choice);
        if (hasArgument.get(choice)) {
            return constructor.newInstance(random);
        }

        return constructor.newInstance();
    }
}
