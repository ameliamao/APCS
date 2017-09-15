/**
 * The class Conditional is composed of two logical sentences and evaluates
 * according to the "->" operator
 * @author ameliamao
 */
public class Conditional extends LogicalSentence{
	LogicalSentence left;
	LogicalSentence right;

	//constructor
	public Conditional(LogicalSentence left, LogicalSentence right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	/**
	 * if the truth value of the negation of the first value is true
	 * or the right value is true, then the return is true 
	 * @param t: contains the truth values of the logical sentences
	 * @return a boolean
	 */
	@Override
	public boolean evaluate(TruthAssignment t) {
		boolean retval = !left.evaluate(t) || right.evaluate(t);
		return retval;
	}
}