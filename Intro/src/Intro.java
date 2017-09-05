/**
 * does intro problems
 * @author amelia
 */
public class Intro {
	
	public static void main(String[] args) {
		System.out.println(ret());
		System.out.println(logic(true, true, false));
		System.out.println(stars(4));
		System.out.println(coins(18));
	}
	
	/**
	 * @return the number 17
	 */
	public static int ret() {
		return 17;
	}
	
	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return the logical and of 3 passed in booleans
	 */
	public static boolean logic(boolean a, boolean b, boolean c) {
		boolean logicalAnd = a&&b&&c;
		return logicalAnd;
	}
	
	/**
	 * returns a string of a star pyramid 
	 * with the specified # of rows
	 * @param n is the number of rows of stars
	 * @return a string of a star pyramid
	 */
	public static String stars(int n) {
		String stars = ""; 
		for (int i = 1; i <= n; i++) {
			for (int k = 0; k < i; k++) {
				stars += "*";
			}
			stars +="\n";	
		}
		return stars;
	}
	
	/**
	 * calculates the least amount of 5 and 2 cent coins 
	 * that can be exchanged with the specified amount
	 * of cents passed in
	 * @param n is the # of cents to be exchanged
	 * @return the least amount of 5 and 2 cents possible
	 * if an amount entered cannot be distributed 
	 * between 5 and 2 cents coins alone, -1 is returned
	 */
	public static int coins(int n) {
		int nickel = 5;
		if (n >= nickel) {
			int num = n / nickel;
			int remainder = n % nickel;
			if (remainder % 2 == 0) {
				return num + (remainder / 2);
			}
			return -1;
		} 
		else if (n >= 2 && n % 2 == 0) {
			return n / 2;
		}
		else {
			return -1;
		}
	}
}
