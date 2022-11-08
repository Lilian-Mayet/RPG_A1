public class HealingStick extends Magical_Weapon{

    public HealingStick(){
        this.name = "healing stick";
        this.heal = 30;
        this.cost = 5;

    }



    @Override
    public void interaction(Combatant attacker, Combatant target) {
        if(attacker.getMana()>=this.cost){
            attacker.updateMana(-this.cost);
            int heal = this.heal;

            if(attacker instanceof Healer){heal = (int)Math.round(heal*((Healer) attacker).getHealBoost());}
            else if (attacker instanceof Mage){heal = (int)Math.round(heal*((Mage) attacker).getSpellBoost());}

            target.updateHP(heal);
            System.out.println(attacker.getName() + " spent " + this.cost + " mana to heal " + target.getName() + " " + this.heal + "hp") ;
            System.out.println(target.getName() + " now have " + target.getHealthPoints() + "hp");
        }
        else{
            System.out.println("You don't have enought mana");
        }

    }

}
