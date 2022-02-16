package com.company;

/**
 * This class is a subclass of Robot class.
 *
 * @author Qian Ruiling
 * @version 1.1
 */
public class NinjaBot extends Robot{
    private boolean hide = false;

    /**
     * Constructor, which setup the three properties accordingly.
     *
     * @param name The name of NinjaBot
     * @param power The power of NinjaBot
     * @param lifeIndex The life value of NinjaBox
     */
    public NinjaBot(String name, int power, int lifeIndex) {
        super(name, power, lifeIndex);
    }

    /**
     * This method will hide NinjaBox itself from the next attack.
     * If hid, it will print a prompt to show it is hid.
     *
     */
    public void hide(){
        //todo
        hide = true;
        System.out.println(this.getName() + " hides itself from attacks!");
    }

    /**
     * This method will first check if it is hidden.
     * If hidden, it takes no damage at all. Otherwise reduce life with the amount specified
     * as usual. Reset the hiding status afterwards.
     *
     * @param amount The amount of damage be taken.
     */
    @Override
    public void damage (int amount){
        //todo
        if (!hide){
            this.lifeIndex = this.lifeIndex - amount;
            System.out.println(this.getName() + " takes a damage of " + amount + "!");
        }else{
            System.out.println(this.getName() + " hides from the attack!");
            hide = false;
        }
    }
}
