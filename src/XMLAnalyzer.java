import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
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
		String xPath = "//UML:StateMachine.top//UML:CompositeState.subvertex/UML:CompositeState";
		List<?> stateList = xmlFile.selectNodes(xPath);
		Iterator<?> iterator = stateList.iterator();
		while (iterator.hasNext()) {
			Element element = (Element)iterator.next();
			String name = element.attributeValue("name");
			if (name == "") {
				iterator.remove();
			}
		}
		
		System.out.println(stateList.size());
		for (Object o : stateList) {
			Element element = (Element)o;
			System.out.println(element.attribute("name").getValue());
			
		}
		
		
	}
}
