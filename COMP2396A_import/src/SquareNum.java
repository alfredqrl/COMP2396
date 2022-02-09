import java.io.*;
import java.io.*;
import java.lang.*;

/**
 * This class demonstrates documentation comments.
 *
 * @author Herbert Schildt
 * @version 1.2
 */
public class SquareNum {
	/**
	 * This method returns the square of num. This is a multiline description. You
	 * can use as many lines as you like.
	 *
	 * @param num.
	 * @return num squared.
	 */

	public double square(double num) {
		return num * num;
	}

	/**
	 * This method inputs a number from the user.
	 *
	 * @return the value input as double.
	 * @throws IOException On input error.
	 * @see IOException
	 */
	public double getNumber() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader inData = new BufferedReader(isr);
		String str;
		str = inData.readLine();
		return (Double.parseDouble(str));
	}

	/**
	 * This method demonstrates square().
	 *
	 * @param args Unused.
	 * @throws IOException On input error.
	 * @see IOException
	 */

	public static void main(String[] args) throws IOException {
		SquareNum ob = new SquareNum();
		double val;
		System.out.println("Enter value to be squared: ");
		val = ob.getNumber();
		val = ob.square(val);
		System.out.println("Squared value is " + val);
	}

}





