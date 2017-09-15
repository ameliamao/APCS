INTRODUCTION: 
	This is the LogicPuzzle Project. It is a program that creates, checks, and uses logic sentences. 

SPECIFICATIONS:
	I believe this program fulfills all the required specifications. However, as the instruction for some of the functions were quite dubious, I am not 100% sure. There are currently no noticeable errors in the code.s
	
CODE OVERVIEW:
	There are 8 different classes: PropositionConstant, LogicSentence, TruthAssignment, 		Conjunction, Disjunction, Negation, Biconditional and Conditional. The PropositionConstant class creates an object containing a simple string(currently only containing single characters). The LogicSentence class is constructed out of a single proposition constant and contains many helper methods for subclasses. The TruthAssignment class is composed of one hashMap of proposition constants and their corresponding booleans. The Conjunction, Disjunction, Negation, Biconditional and Conditional classes are all subclasses of LogicSentence that contain a method to calculate their boolean value according to their respective logical operator, i.e "and" for conjunction, "not" for negation, or "iff" for biconditional.
	
CHALLENGES:
	The major challenge I encountered was creating the truth table because I was unsure as to how I should create it and what I should do. I later figured out that I should just print out all the possible logic combinations of the passed in list of strings. Another challenge I faced was figuring out what findMatch() should do because of the parameters that should be passed in, specifically the integer. I ended up not using the integer argument at all, instead just finding the rightmost character using a for loop.
	
ACKNOWLEDGEMENTS: 
	I consulted https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html for information on the hashMap data type.
	I would like to give credit to Quintin for giving me the idea of using 0 and 1's for the truth table. And finally I would like to thank my friends, namely Sophia and Amy for helping me through various problems.