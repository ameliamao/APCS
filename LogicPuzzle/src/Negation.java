/**
 * The class Negation is composed of a single logical sentence.
 * It negates the truth value of the logical sentence,
 * changing it from true to false or vice versa
 * @author ameliamao
 */
public class Negation extends LogicalSentence{
	private LogicalSentence ls;
	
	//constructors
	public Negation(LogicalSentence ls) {
		super();
		this.ls = ls;
	}
	
	/**
	 * negates(switches) the truth value of the logical sentence
	 * @param t: contains the truth value of the logical sentence
	 * @return a boolean of the opposite of the logical sentence's original truth value
	 */
	@Override
	public boolean evaluate(TruthAssignment t){
		boolean retval = !ls.evaluate(t);
		return retval;
	}

}
