import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);




    Hero c1 = new Warrior("hero_1",100,20,0,50);
    Hero c2 = new Hunter("hero_2",100,20,20,50);
    Hero c3 = new SpellCaster("hero_3",100,20,0,50);
    Hero c4 = new Warrior("hero_4",100,20,0,50);






    Enemy enemy1 = new Enemy("enemy_1",100,40,0,60);
    Enemy enemy2 = new Enemy("enemy_2",100,40,0,60);




    //create weapon
    Sword sword = new Sword();
    Axe axe = new Axe();
    HealingStick healingStick = new HealingStick();

    //create item
    Apple apple = new Apple();
    ManaPotion manaPotion = new ManaPotion();


    c1.addArmory(sword);
    c1.addArmory(axe);
    c1.addInventory(apple);
    c1.addInventory(manaPotion);

    c2.addInventory(manaPotion);

    c3.addArmory(axe);
    c3.addArmory(healingStick);

    c4.addArmory(sword);


    Equipe equipe = new Equipe();
    equipe.addHero(c1);
    equipe.addHero(c2);
    equipe.addHero(c3);
    equipe.addHero(c4);

    equipe.upgrade();


    Horde horde = new Horde();
    horde.addEnemy(enemy1);
    horde.addEnemy(enemy2);


    System.out.println("Your team :" );
    equipe.printHero();

    System.out.println();
        System.out.println("Enemy team :");
    horde.printEnemy();



    int turn = 0;
    while (horde.isDead()==false){
        System.out.println("\n");
        System.out.println("It's the turn of " + equipe.getHero(turn).getName());
        System.out.print("He has " + equipe.getHero(turn).getHealthPoints()  + " hp and " );
        System.out.println(equipe.getHero(turn).getMana() + " mana.");

        //action du hero
        boolean choiceDone = false;
        while (choiceDone==false){
            System.out.println("Do you want to see the inventory(1), interact(2) or use an item(3)?");
            System.out.print("Type 1, 2 or 3 : ");
            int choice = scan.nextInt();
            if (choice==1){
                equipe.getHero(turn).printInventory();
                System.out.println("\n");
            }

            else if (choice==2){
                choiceDone = true;

                System.out.println("Do you want to target your team(1) or the enemy team(2)?");
                System.out.print("Type 1 or 2 :");
                int choice2 = scan.nextInt();
                if (choice2==1){
                    System.out.println("Your team is composed of :");
                    equipe.printHero();
                    System.out.println("Wich one do you want to target?");
                    System.out.print("Type his number");
                    int target = scan.nextInt();
                    equipe.getHero(turn).interact(equipe.getHero(target-1));
                }

                else if (choice2==2){
                    System.out.println("The enemy team is composed of :");
                    horde.printEnemy();
                    System.out.println("Wich one do you want to target?");
                    System.out.print("Type his number");
                    int target = scan.nextInt();
                    equipe.getHero(turn).interact(horde.getEnemy(target-1));
                    horde.getEnemy(target-1).updateAlive();
                    if (horde.getEnemy(target-1).getIsAlive()==false){
                        System.out.println(horde.getEnemy(target-1).getName() + " is dead");
                        horde.removeEnemy(horde.getEnemy(target-1));}

                }

                System.out.println("\n");

            }

            else if (choice==3){
                choiceDone = true;
                equipe.getHero(turn).consume();
            }

            else{
                System.out.println("Instruction unclear");
                System.out.println("\n");
            }
        }


        //update turn
        if(turn<equipe.getSize()-1){turn++;}
        else {turn=0;}


    }


        System.out.println("\n" + "\n" + "\n");
        System.out.println("You defeated the enemy team");


    }
}
