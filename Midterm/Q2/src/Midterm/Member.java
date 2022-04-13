package Midterm;

public class Member {
    private String name;
    private int credit;
    private Member belong;

    public Member(String name, int credit){
        this.name = name;
        this.credit = credit;
    }

    public Member(String name, Member belong){
        this.name = name;
        this.belong = belong;
    }

    public Member subMember(String name){
        return new Member(name, this);
    }

    public String purchase(Product a){
        if (this.belong != null){
            if (this.belong.getCredit() < a.getPrice()){
                return "The membership does not have enough credit. Wing cannot buy this product.";
            }
            else{
                String returnVal =  this.getName() + " spend $" + a.getPrice() + ". The membership has $" + (this.belong.getCredit() - a.getPrice()) + " left.";
                setCredit(this.belong,this.belong.getCredit() - a.getPrice());
                return returnVal;
            }
        }
        if (this.getCredit() < a.getPrice()){
            return "The membership does not have enough credit. Wing cannot buy this product.";
        }
        else{
            String returnVal =  this.getName() + " spend $" + a.getPrice() + ". The membership has $" + (this.getCredit() - a.getPrice()) + " left.";
            setCredit(this,this.getCredit() - a.getPrice());
            return returnVal;
        }
    }

    private String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(Member a, int credit){
        a.credit = credit;
    }
}
