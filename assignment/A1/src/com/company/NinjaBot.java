package com.company;

public class NinjaBot extends Robot{
    private boolean hide = false;

    public NinjaBot(String name, int power, int lifeIndex) {
        super(name, power, lifeIndex);
    }

    public void hide(){
        //todo
        hide = true;
        System.out.println(this.name + " hides itself from attacks!");
    }

    @Override
    public void damage (int amount){
        //todo
        if (!hide){
            this.lifeIndex = this.lifeIndex - amount;
            System.out.println(this.name + " takes a damage of " + amount + "!");
        }else{
            System.out.println(this.name + " hides from the attack!");
            hide = false;
        }
    }
}
