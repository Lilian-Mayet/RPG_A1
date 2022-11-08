import java.util.Scanner;

public class Hunter extends Hero{

    private int arrowLeft;

    public Hunter(String name, int healthPoints, int strenght, int mana, int defense) {
        super(name, healthPoints, strenght, mana, defense);
        this.arrowLeft = 10;
        Bow bow = new Bow();
        Fist fist = new Fist();
        this.addArmory(bow);
        this.addArmory(fist);

    }

    public int getArrowLeft(){return this.arrowLeft;}

    public void updateArrow(int delta){this.arrowLeft += delta; }

    @Override
    public void interact(Combatant target){
        System.out.println("You are about to interact with " + target.getName() + " (HP = " + target.getHealthPoints());
        System.out.println(" , defense = " + target.getDefense() + " )");


        if(this.getArrowLeft()>0){
            this.updateArrow(-1);
            System.out.print(this.getName() + " used 1 arrow(" + this.getArrowLeft() + " left).");
            this.getArmory().get(0).interaction(this,target);
        }
        else {
            System.out.print("You don't have any arrow left, you use your first.");
            this.getArmory().get(1).interaction(this,target);
        }





    }



}
