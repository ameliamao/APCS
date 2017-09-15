import java.util.Arrays;

/**
 * The Logical Sentence class is composed of one proposition constant.
 * It detects legal sentences and contains helper methods 
 * for subclasses Negation, Conjunction, and Disjunction
 * @author ameliamao
 */
public class LogicalSentence {
	private PropositionConstant propc;
	
	public static void main(String[] args) {
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		LogicalSentence l5 = new Conjunction(l3, new Negation(l4));
		
		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b,true);
		ta1.put(a, false); 
		
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a&"));
		System.out.println(findMatch("a((b)", 0));

		String[] pc = {"p", "q", "r"};
		truthTable(pc);
	}
	
	private PropositionConstant pc;
	
	//constructors
	public LogicalSentence(){}//empty for use of subclasses
	public LogicalSentence(PropositionConstant pc) {
		this.pc = pc;
	}
	
	/**
	 * just a getter
	 * @return the proposition constant of the logical sentence
	 */
	public PropositionConstant getpropConst() {
		return pc;
	}
	
	/**
	 * prints out a truth table of all the proposition constants passed in
	 * @param list: the list of strings
	 */
	public static void truthTable(String[] list) {
		System.out.println("\n-------------------"); //for nice formatting
		System.out.println(Arrays.toString(list));
		System.out.println("-------------------"); //also for nice formatting
        int rows = (int) Math.pow(2, list.length);
        for (int i=0; i<rows; i++) {
            for (int j=list.length-1; j>=0; j--) {
            	String bool = (i/(int) Math.pow(2, j)) % 2 == 1? "T" : "F";
                System.out.print(" "+ bool + " "); //spaces are again for nice formatting
            }
            System.out.println();
        }
    }
	
	/**
	 * finds the boolean value of a proposition constant 
	 * @param ta: an object that contains the boolean values of prop constants(a hashMap)
	 * @return the boolean value of the object calling this method
	 */
	public boolean evaluate(TruthAssignment ta) {
		if (ta.getBool(this.getpropConst()) == true) {
			return true;
		} 
		return false;
	}
	
	/**
	 * finds the the index of the rightmost character in 
	 * the first substring of the argument that is enclosed by 
	 * matching parenthesis and which contains no parenthesis
	 * @param s: the string that is looked through
	 * @param i: an unused integer
	 * @return the index of the rightmost character in 
	 * the first substring
	 */
	public static int findMatch(String s, int i) {
		boolean withinParenthesis = false;
		for (i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (letter == '(') {
				withinParenthesis = true;
			} 
			else if (letter == ')') {
                if (withinParenthesis) {
                    return i-1;
                }
                withinParenthesis = false;
            }
        }
        return -1; //if the string does not meet the requirements 
	}
	
	/**
	 * determines if a string is legal
	 * @param s: the string entered
	 * @return boolean true/false
	 */
	public static boolean legal(String s) {
		s = s.replace(" ", ""); //removes all spaces from string entered
		if (s.equals("")) { //method does not allow for blanks strings
			return false;
		}
		else if (simpleSentence(s)) {
			return true;
		}
		else if (beginsWithNot(s)) {
			return legal(cutNot(s));
		}
		else if (s.length() > 2 && findFirstOp(s) != -1) {
			int lhsIndex = findFirstOp(s);
			int rhsIndex = findRightIndexOp(s);
			if (rhsIndex == -1 || s.contains(">") && s.charAt(rhsIndex - 1) != '=') { //error checking for strings with illegal operators
				return false;
			}
			String lhs = s.substring(0, lhsIndex); //first part before operator
			String rhs = s.substring(rhsIndex + 1); //part after operator
			return legal(lhs) && legal(rhs);
		}
		else {
			return false;
			}
	}
	
	/**
	 * checks if string is a legal string
	 * @param s: the input string
	 * @return boolean true for legal string
	 */
	public static boolean simpleSentence(String s) {
		if (s.equals("p") || s.equals("q")) {
			return true;
		} 
		return false;
	} 
	
	/**
	 * checks if string begins with "~"
	 * @param s: is string inputed
	 * @return boolean for string containing "~"
	 */
	public static boolean beginsWithNot(String s) {
		if (s.charAt(0) == ('~')) {
			return true;
		} 
		return false;
	}
	
	/**
	 * deletes "~" from string
	 * @param s: string
	 * @return substring of s without the "~"
	 */
	public static String cutNot(String s) {
		return (s.substring(1, s.length()));
	}
	
	/**
	 * checks all possibilities of logical operators 
	 * @param s: string
	 * @return index of operator in string
	 */
	public static int findFirstOp(String s) {
		if (s.contains("|")) {
			return s.indexOf("|");
		}
		else if (s.contains("<=")) {
			return s.indexOf("<"); 
		}
		else if (s.contains("&")) {
			return s.indexOf("&");
		}
		else if (s.contains("=")) {
			return s.indexOf("=");
		}
		else {
			return -1;
		}
	}
	
	/**
	 * finds index of the right hand side of the operators "=>" and "<=>"
	 * @param s
	 * @return index of the rhs of the operator 
	 * (which may be the same as the lhs in the case of a single char operator)
	 */
	public static int findRightIndexOp(String s) {
		if (s.length() > 3 && s.indexOf(">") != -1) {
			return s.indexOf(">");
		}
		return findFirstOp(s);
	}
}

