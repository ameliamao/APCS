 /**
 * The class conjunction is composed of two logical sentences and checks if 
 * they in disjunction, are true or false
 * @author ameliamao
 */
public class Disjunction extends LogicalSentence{
	LogicalSentence left;
	LogicalSentence right;

	//constructor
	public Disjunction(LogicalSentence left, LogicalSentence right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	/**
	 * evaluates if the 2 logical sentences in disjunction are true,
	 * according to logical or
	 * @param t: contains the truth values of the logical sentences
	 * @return a boolea on the logical or of the 2 logical sentences
	 */
	@Override
	public boolean evaluate(TruthAssignment t) {
		boolean retval = left.evaluate(t) || right.evaluate(t);
		return retval;
	}
}
