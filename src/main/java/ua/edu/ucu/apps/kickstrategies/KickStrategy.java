package ua.edu.ucu.apps.kickstrategies;

import ua.edu.ucu.apps.characters.Character;

public interface KickStrategy {
    public void kick(Character kicker, Character kicked);
}
