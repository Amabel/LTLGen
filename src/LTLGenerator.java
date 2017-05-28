import java.io.File;
import java.io.FileNotFoundException;

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
		readXMLFile();
		
		return null;
	}
	
	private Document readXMLFile() {
		String fileName = this.fileName;
		SAXReader saxReader = new SAXReader();
		
		try {
			File inputFile = new File(fileName);
			Document xmlFile = saxReader.read(inputFile);
			System.out.println(xmlFile);
			
		} catch (DocumentException e2) {
//			e2.printStackTrace();
			System.out.println("connot find file: " + fileName);
		}
		return null;
	}
}
