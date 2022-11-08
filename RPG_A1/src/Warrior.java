import java.util.Scanner;

public class Warrior extends Hero{
    private double damageBoost;

    public Warrior(String name, int healthPoints, int strenght, int mana, int defense) {
        super(name, healthPoints, strenght, mana, defense);
        this.damageBoost=2;
    }

    public double getDamageBoost() {
        return damageBoost;
    }

    public void updateDamageBoost(double boost){
        this.damageBoost *= boost;
    }
}
