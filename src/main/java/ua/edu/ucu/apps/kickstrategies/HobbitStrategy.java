package ua.edu.ucu.apps.kickstrategies;

import ua.edu.ucu.apps.characters.Character;
import ua.edu.ucu.apps.characters.Hobbit;

public class HobbitStrategy implements KickStrategy {
    @Override
    public void kick(Character kicker, Character kicked) {
        if (kicker instanceof Hobbit) {
            ((Hobbit) kicker).toCry();
        }
    }
}
