import java.util.Scanner;

import formula.LTL;

/**
 * @author  Weibin Luo
 * @version Created on 2017/05/22 15:27:45
 */
public class LTLGenController {
	
	private LTLGenerator ltlGenerator;

	public void launch() {
		int debugMode = 0;
		
		String fileName = null;
		
		if (debugMode == 1) {
			// for debug
			fileName = "examples/response chain/response chain-globally.z151";
		} else {
			// input mode
			fileName = readInputFileName();
		}

		ltlGenerator = new LTLGenerator(fileName);
		LTL ltl = ltlGenerator.generate();
		
		printResults(ltl);
		
	}
	
	private String readInputFileName() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();
		return fileName;
	}
	
	private void printResults(LTL ltl) {
		if (ltl != null) {
			System.out.println("Pattern: " + ltl.getPattern());
			System.out.println("Scope:   " + ltl.getScope());
			System.out.println("LTLFormula: " + ltl.getFomula());
		}
	}
}
