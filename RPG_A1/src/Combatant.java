import java.util.ArrayList;
import java.util.Scanner;


public abstract class Combatant {


    private String name;
    private int healthPoints;
    private int strenght;
    private  int mana;
    private  int defense;
    private  boolean isAlive;


    private int[] position;
    private ArrayList<Consummable> inventory;
    private ArrayList<Weapon> armory;



    public Combatant(String name,int healthPoints,int strenght,int mana, int defense){
        this.name = name;
        this.healthPoints = healthPoints;
        this.strenght = strenght;
        this.mana = mana;
        this.defense = defense;
        this.armory= new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.isAlive = true;

    }

    //getter

    public String getName(){return this.name;}

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public int getStrenght() {
        return this.strenght;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getMana() {
        return this.mana;
    }

    public boolean getIsAlive(){return this.isAlive;}

    public ArrayList<Weapon> getArmory() {
        return this.armory;
    }

    public ArrayList<Consummable> getInventory() {
        return this.inventory;
    }




    //Update

    public void addArmory(Weapon weapon){
        this.armory.add(weapon);
    }

    public void deleteArmory(Weapon weapon){
        this.armory.remove(weapon);
    }

    public void addInventory(Consummable consummable){
        this.inventory.add(consummable);
    }

    public void deleteInventory(Consummable consummable){this.inventory.remove(consummable);}

    public void updateHP(int delta){
        this.healthPoints += delta;
    }

    public void updateMana(int delta){
        this.mana += delta;
    }

    public void updateAlive(){
        if(this.healthPoints<=0){
            this.isAlive = false;
        }
    }


    //print
    public void printInventory() {
        if (this.getInventory().size() == 0) {
            System.out.println("You don't have any item.");
        } else {
            System.out.print("You have : ");
            for (int i = 0; i < this.getInventory().size(); i++) {
                if (i == this.getInventory().size() - 1) {
                    System.out.print(this.getInventory().get(i).name + " .");
                } else {
                    System.out.print(this.getInventory().get(i).name + " / ");
                }

            }
            System.out.println();
        }

        System.out.print("In your armory you have : ");
        for (int i = 0; i < this.getArmory().size(); i++) {
            if (i == this.getArmory().size() - 1) {
                System.out.print(this.getArmory().get(i).name + " .");
            } else {
                System.out.print(this.getArmory().get(i).name + " / ");
            }

        }


    }






}
