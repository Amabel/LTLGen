import java.util.Scanner;

/**
 * @author  Weibin Luo
 * @version Created on 2017/05/22 15:27:45
 */
public class LTLGenController {
	
	private LTLGenerator ltlGenerator;

	public void launch() {
		
		String fileName = readInputFileName();
		ltlGenerator = new LTLGenerator(fileName);
		ltlGenerator.generate();
		
	}
	
	private String readInputFileName() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();
		return fileName;
	}
}
