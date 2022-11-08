public class Mage extends SpellCaster {

    private double spellBoost;

    public Mage(String name, int healthPoints, int strenght, int mana, int defense) {
        super(name, healthPoints, strenght, mana, defense);
        this.spellBoost = 1.2;
    }


    public double getSpellBoost() {
        return spellBoost;
    }

    public void updateSpellBoost(double boost){
        this.spellBoost *= boost;
    }
}
