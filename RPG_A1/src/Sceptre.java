public class Sceptre extends Magical_Weapon{

    public Sceptre(){
        this.name = "screptre";
        this.cost = 20;
        this.damage = 60;
    }

    @Override
    public void interaction(Combatant attacker, Combatant target) {
        if(attacker.getMana()>=this.cost){
            attacker.updateMana(-this.cost);
            int damage = this.damage;
            if(attacker instanceof Mage){heal = (int)Math.round(heal*((Mage) attacker).getSpellBoost());}
            target.updateHP(heal);
            System.out.println(attacker.getName() + " spent " + this.cost + " mana to heal " + target.getName() + " " + this.heal + "hp") ;
            System.out.println(target.getName() + " now have " + target.getHealthPoints() + "hp");
        }
        else{
            System.out.println("You don't have enought mana");
        }

    }

}
