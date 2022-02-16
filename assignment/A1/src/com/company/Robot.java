package com.company;

/**
 * This class is for the main robot class
 *
 * @author Qian Ruiling
 * @version 1.1
 */
public class Robot {

    String name;
    int power;
    int lifeIndex;

    public Robot(String name, int power, int lifeIndex){
        //TODO
        this.name = name;
        this.power = power;
        this.lifeIndex = lifeIndex;
    }

    public String getName() {
        return name;
    }

    public void damage(int amount){
        //todo
        this.lifeIndex = this.lifeIndex - amount;
        System.out.println(this.name + " takes a damage of " + amount + "!");
    }

    public int attack(){
        //todo
        System.out.println(this.name + " launch an attack!");
        return this.power;
    }

    public boolean isBroken(){
        //todo
        return this.lifeIndex <= 0;
    }
}
