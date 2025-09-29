import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.characters.Character;
import ua.edu.ucu.apps.characters.Elf;
import ua.edu.ucu.apps.kickstrategies.KickStrategy;;

class ElfTest {
    static class DummyStrategy implements KickStrategy {
        @Override
        public void kick(Character kicker, Character kicked) {}
    }

    static class DummyCharacter extends Character {
        public DummyCharacter(int power, int hp) {
            super(power, hp, new DummyStrategy());
        }
    }

    @Test
    void testKickWhenTargetHpLess() {
        Elf elf = new Elf(); // hp=10, power=10
        DummyCharacter target = new DummyCharacter(5, 5); // power < elf power

        elf.kick(target);

        assertEquals(false, target.isAlive(), "Target should die");
    }

    @Test
    void testKickWhenTargetHpEqual() {
        Elf elf = new Elf(); // hp=10, power=10
        DummyCharacter target = new DummyCharacter(10, 15); // power == elf power

        elf.kick(target);

        assertEquals(9, target.getPower(), "Target's power should be reduced by 1");
        assertEquals(15, target.getHp(), "Target's hp should remain unchanged");
    }

    @Test
    void testKickWhenTargetHpGreater() {
        Elf elf = new Elf(); // hp=10, power=10
        DummyCharacter target = new DummyCharacter(15, 15); // power >= elf power

        elf.kick(target);

        assertEquals(14, target.getPower(), "Target's power should be reduced by 1");
        assertEquals(15, target.getHp(), "Target's hp should remain unchanged");
    }

    @Test
    void testMultipleKicksReducePower() {
        Elf elf = new Elf(); // hp=10, power=10
        DummyCharacter target = new DummyCharacter(12, 20); // power >= power hp

        elf.kick(target); // reduces power from 12 -> 11
        assertEquals(11, target.getPower(), "Target's power should be reduced by 1");
        elf.kick(target); // 11 -> 10
        assertEquals(10, target.getPower(), "Target's power should be reduced by 1");
        elf.kick(target); // 10 -> 9
        assertEquals(9, target.getPower(), "Target's power should be reduced by 1");
        assertEquals(20, target.getHp(), "Target's hp should remain unchanged");

        elf.kick(target); // 9 -> 0
        assertEquals(false, target.isAlive(), "Target should die");
    }
}
