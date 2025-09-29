package ua.edu.ucu.apps.characters;

import ua.edu.ucu.apps.kickstrategies.ElfStrategy;

public class Elf extends Character {
    public Elf() {
        super(10, 10, new ElfStrategy());
    }
}
