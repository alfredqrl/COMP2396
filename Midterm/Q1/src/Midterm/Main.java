package Midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = input.readLine();
        String [] inputArr = inputLine.split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        //int more = 0;
        int foils = n;

        while (true) {
            int exchange = foils / m;
            foils = foils % m;
            if (exchange == 0){
                break;
            }else{
                n = n + exchange;
                foils = foils + exchange;
            }
        }


        //int total = n + more;
        System.out.println("The max chocolates you have eventually:" + n);
    }
}
