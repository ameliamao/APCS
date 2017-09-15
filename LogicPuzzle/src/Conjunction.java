/**
 * The Conjunction class is composed of two logical sentences and checks if 
 * they in conjunction, are true or false
 * @author ameliamao
 */
public class Conjunction extends LogicalSentence{
	LogicalSentence left;
	LogicalSentence right;

	//constructor
	public Conjunction(LogicalSentence left, LogicalSentence right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	/**
	 * evaluates if the 2 logical sentences in conjunction are true,
	 * according to logical and
	 * @param t: contains the truth values of the logical sentences
	 * @return a boolean on the logical and of the 2 logical sentences
	 */
	@Override
	public boolean evaluate(TruthAssignment t) {
		boolean retval = left.evaluate(t) == right.evaluate(t);
		return retval;
	}
}
