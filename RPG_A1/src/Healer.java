public class Healer extends SpellCaster {

    private double healBoost;


    public Healer(String name, int healthPoints, int strenght, int mana, int defense) {
        super(name, healthPoints, strenght, mana, defense);
        this.healBoost = 1.5;
    }


    public double getHealBoost(){return this.healBoost;}

    public void updateHealBoost(double boost){
        this.healBoost *= boost;
    }

}
