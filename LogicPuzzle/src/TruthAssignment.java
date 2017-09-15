import java.util.HashMap;

/**
 * This class is creates a HashMap of proposition constants and booleans
 * @author ameliamao
 */
public class TruthAssignment {
	HashMap<PropositionConstant,Boolean> ta = new HashMap<PropositionConstant,Boolean>(); //creates the hashMap
	
	/**
	 * puts the passed in values into the hashMap
	 * @param p: the key
	 * @param b: the value
	 */
	public void put(PropositionConstant p, Boolean b) {
		ta.put(p, b);
	}
	
	/**
	 * gets the corresponding boolean value to the passed in proposition constant
	 * @param p: the proposition constant
	 * @return: the boolean value of the parameter
	 */
	public boolean getBool(PropositionConstant p) {
		return ta.get(p);
	}
}
