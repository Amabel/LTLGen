import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

public class XMLAnalyzer {
	
	Document xmlFile;
	
	public XMLAnalyzer(Document xmlFile) {
		this.xmlFile = xmlFile;
	}
	
	public String analyze() {
		String ltlFormula = null;
		
		analyzeXMLFile();
		return ltlFormula;
	}

	private void analyzeXMLFile() {
		// for trigger pattern
		String xPath = "//book";
		List list = xmlFile.selectNodes(xPath);
//		Element root = xmlFile.getRootElement();
//		List nodes = root.elements("XMI.content");
		
		System.out.println(list);
//		System.out.println(nodes);
		
		
	}
}
