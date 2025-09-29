package ua.edu.ucu.apps.characters;

import lombok.Getter;
import ua.edu.ucu.apps.kickstrategies.KickStrategy;

public class Character {
    @Getter
    private int power;
    @Getter
    private int hp;

    private KickStrategy kickStrategy;

    public void setPower(int power) {
        this.power = power > 0 ? power : 0;
    }

    public void setHp(int hp) {
        this.hp = hp > 0 ? hp : 0;
    }

    public Character(int power, int hp, KickStrategy kickStrategy) {
        this.power = power > 0 ? power : 0;
        this.hp = hp > 0 ? hp : 0;
        this.kickStrategy = kickStrategy;
    }

    public void kick(Character c) {
        kickStrategy.kick(this, c);
    };

    public boolean isAlive() {
        return hp > 0;
    }
}
