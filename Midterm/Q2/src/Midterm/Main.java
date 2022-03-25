package Midterm;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Member wing = new Member("Wing", 200);
        Member joy = wing.subMember("Joy");
        Member marco = wing.subMember("Marco");
        Member kiu = new Member("Kiu", 1000);
        Product b1 = new Product(70);
        Product b2 = new Product(100);
        System.out.println(joy.purchase(b1));
        System.out.println(marco.purchase(b2));
        System.out.println(wing.purchase(b1));
        System.out.println(kiu.purchase(b2));
    }
}
