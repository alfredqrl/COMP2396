package com.company;

/**
 * This class is for the main robot class.
 *
 * @author Qian Ruiling
 * @version 1.1
 */
public class Robot {

    String name;
    int power;
    int lifeIndex;

    /**
     * Constructor, which setup the three properties accordingly.
     *
     * @param name The name of the robot.
     * @param power The attack level value of the robot.
     * @param lifeIndex The life value of the robot.
     */
    public Robot(String name, int power, int lifeIndex){
        //TODO
        this.name = name;
        this.power = power;
        this.lifeIndex = lifeIndex;
    }

    /**
     * This method is a get method, which returns the name of this Robot
     *
     * @return The name of the Robot
     */
    public String getName() {
        return name;
    }

    /**
     * This method will reduce the life value due to damage and provide prompt messages.
     *
     * @param amount The amount of damage be taken.
     */
    public void damage(int amount){
        //todo
        this.lifeIndex = this.lifeIndex - amount;
        System.out.println(this.getName() + " takes a damage of " + amount + "!");
    }

    /**
     * Return the power of the next attack.
     * It always return the value of the level property.
     *
     * @return The attack value.
     */
    public int attack(){
        //todo
        System.out.println(this.getName() + " launches an attack!");
        return this.power;
    }

    /**
     * This method is judging whether the robot is broken.
     * If the life value less than or equal to 0, then the robot is broken.
     *
     * @return whether the robot is broken.
     */
    public boolean isBroken(){
        //todo
        return this.lifeIndex <= 0;
    }
}
