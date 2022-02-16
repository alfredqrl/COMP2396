package com.company;

// todo: fix inheritance
public class PowerBot extends Robot{
    private boolean boost = false;
    //private int pow;

    public PowerBot(String name, int power, int lifeIndex){
        super(name, power, lifeIndex);
    }

    public void boost(){
        //todo
        boost = true;
        System.out.println(this.name + "boosts itself!");
    }

    @Override
    public int attack(){
        //todo
        if (boost){
            System.out.println(this.name + " makes a heavy strike!");
            boost = false;
            //pow = this.power * 2;
            return this.power * 2;
        }else{
            System.out.println(this.name + " strikes hard!");
            return this.power;
        }
        //return 0;
    }
}
