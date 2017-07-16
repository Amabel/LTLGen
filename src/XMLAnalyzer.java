import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

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
		// select attribute: [@*[name()='xsi:type']]
		String xPathNodes = "//ucmMaps/nodes[@*[name()='xsi:type']]";
		List<?> nodesList = xmlFile.selectNodes(xPathNodes);
		
		// # of <nodes>
		System.out.println("Found <nodes> with attribute @xsi:type: " + nodesList.size());
		
		// # of <nodes> with @xsi:type=DirectionArrow
		int count = findNode(nodesList, "type", "DirectionArrow").size();
//		System.out.println("//nodes[@xsi:type=DirectionArrow] count: " + count);

		if (count == 0) {
			// no direction arrow
			// absence, existence, bounded existence, universality
			
			// find //nodes@xsi:type=RespRef
			List<Element> nodesRespRefList = findNode(nodesList, "type", "RespRef");
			int nodesRespRefCount = nodesRespRefList.size();
			if (nodesRespRefCount != 1) {
				// error: too many respRefs
			} else {
				// decide the pattern
				
				// find //responsibilities/name
				String xPathRespName = "//responsibilities/name";
				String respName = ((Element)(xmlFile.selectNodes(xPathRespName).get(0))).getText();
				
				System.out.println(respName);
				
				// REs
				// absence: not(P)
				// existence: exist(P)
				// bounded existence: P(..m)
				// universality: univ(P)
				Pattern pattern = Pattern.compile("(.*)\\((.*)\\)");
				Matcher m = pattern.matcher(respName);
				if (!m.matches()) {
					// error incorrect resp name 
				} else {
					// match the pattern [not, exist, be, univ]
					// e.g.: not(P)
					// group(1): not, group(2): P
					String g1 = m.group(1);
					String g2 = m.group(2);
					
//					if (g1.equals("not")) {
//						// absence pattern
//					} else if (g1.)
					switch (g1) {
					case "not":
						// absence
						break;
					case "exist":
						// existence
						
						break;
					case "be":
						// bounded existence
						break;
					case "univ":
						// universality
						
						break;
					default:
						// error: no matching patterns
						break;
					}
				}
				
				
				
				
			}
			
		} else if (count == 1) {
			// 1 direction arrow
			// precedence, response, 2 of chain...
		} else {
			// error: too many direction arrows
		}
		
	}
	
	private List<Element> findNode(List<?> list, String attributeName, String attributeValue) {
		List<Element> ret = new ArrayList<>();
		for (Object o : list) {
			Element element = (Element)o;
			System.out.println(element.attribute(attributeName).getValue());
			Attribute attribute = element.attribute(attributeName);
			if (attribute != null) {
				String value = attribute.getValue();
				if (value.equals(attributeValue)) {
					ret.add(element);					
				}
			}
		}
		return ret;
	}
	
	private void dumpNodeList(List<?> list) {
		for (Object o : list) {
			Element element = (Element)o;
//			System.out.println(element.attribute("type").getValue());
			System.out.println(element);
		}
	}
}
