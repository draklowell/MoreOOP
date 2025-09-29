package ua.edu.ucu.apps;

import ua.edu.ucu.apps.characters.Character;

public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        Character character1, character2;
        character1 = factory.createCharacter();
        character2 = factory.createCharacter();

        GameManager manager = new GameManager(System.out);

        manager.fight(character1, character2);
    }
}
