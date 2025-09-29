package ua.edu.ucu.apps.kickstrategies;

import ua.edu.ucu.apps.characters.Character;

public class ElfStrategy implements KickStrategy {
    @Override
    public void kick(Character kicker, Character kicked) {
        if (kicker.getPower() > kicked.getPower()) {
            kicked.setHp(0);
        } else {
            kicker.setPower(kicker.getPower() - 1);
        }
    }
}
