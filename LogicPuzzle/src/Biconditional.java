/**
 * The class Biconditional is composed of two logical sentences and checks if 
 * they are equal to each other(true), or not(false)
 * @author ameliamao
 */
public class Biconditional extends LogicalSentence{
	LogicalSentence left;
	LogicalSentence right;

	//constructor
	public Biconditional(LogicalSentence left, LogicalSentence right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	/**
	 * if the truth values of the 2 logical sentences are equal,
	 * then it return true, or it will return false
	 * @param t: contains the truth values of the logical sentences
	 * @return a boolean
	 */
	@Override
	public boolean evaluate(TruthAssignment t) {
		if (left.evaluate(t) == right.evaluate(t)) {
			return true;
		}
		return false;
	}
}
