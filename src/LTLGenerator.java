import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * @author  Weibin Luo
 * @version Created on 2017/05/26 17:35:26
 */
public class LTLGenerator {
	
	private String fileName;
	
	public LTLGenerator(String fileName) {
		this.fileName = fileName;
	}
	
	public String generate() {
		
		// start jobs
		
		return null;
	}
	
	private Document readXMLFile(String fileName) {
		SAXReader saxReader = new SAXReader();
		
		try {
			File inputFile = new File(fileName);
			Document XMLFile = saxReader.read(inputFile);
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}
