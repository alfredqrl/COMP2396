package com.company;

/**
 * This class is a subclass of Robot class.
 *
 * @author Qian Ruiling
 * @version 1.1
 */
// todo: fix inheritance
public class PowerBot extends Robot{
    private boolean boost = false;
    //private int pow;

    /**
     * Constructor, which setup the three properties accordingly.
     *
     * @param name The name of PowerBot
     * @param power The power of PowerBot
     * @param lifeIndex The life value of PowerBot
     */
    public PowerBot(String name, int power, int lifeIndex){
        super(name, power, lifeIndex);
    }

    /**
     * This method is to check if the robot is boosted. If yes, provide a prompt message and set the boost to true.
     *
     */
    public void boost(){
        //todo
        boost = true;
        System.out.println(this.getName()+ " boosts itself!");
    }

    /**
     * This is an override method.
     * If boosted, return twice of the level value if it is boosted. Otherwise return the level
     * value as usual. Reset boosting effect afterwards.
     *
     * @return The power of attack
     */
    @Override
    public int attack(){
        //todo
        if (boost){
            System.out.println(this.getName() + " makes a heavy strike!");
            boost = false;
            //pow = this.power * 2;
            return this.power * 2;
        }else{
            System.out.println(this.getName() + " strikes hard!");
            return this.power;
        }
        //return 0;
    }
}
