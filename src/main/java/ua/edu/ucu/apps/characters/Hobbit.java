package ua.edu.ucu.apps.characters;

import ua.edu.ucu.apps.kickstrategies.HobbitStrategy;

public class Hobbit extends Character {
    public Hobbit() {
        super(0, 3, new HobbitStrategy());
    }

    public void toCry() {
        System.out.println("Hobbit cries :(");
    }

    public String toString() {
        return "Hobbit{hp=" + getHp() + ", power=" + getPower() + "}";
    }
}
