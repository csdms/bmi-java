package edu.colorado.csdms.heat;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Represents a model configuration file containing parameter values for the
 * heat model.
 */
public class HeatConfigFile {
  
  private String fileName;
  private Document doc = null;
  private HashMap<String, Double> parameters;

  /**
   * Makes an instance of HeatConfigFile.
   * 
   * @param fileName the path to the configuration file
   */
  public HeatConfigFile(String fileName) {
    this.fileName = fileName;
    this.parameters = new HashMap<String, Double>();
  }
  
  /**
   * Extracts parameter names and values from the file.
   * 
   * @return a {@link HashMap} with parameter names and values
   */
  public HashMap<String, Double> load() {
    loadFile();
    parseParameters();
    return parameters;
  }

  /**
   * Load the contents of an XML file.
   * 
   * @param fileName the name of the XML file
   * @return the file contents as a Document
   */
  private void loadFile() {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db;
    
    try {
      db = dbf.newDocumentBuilder();
      doc = db.parse(new File(fileName));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Parse parameter names and values from the XML document.
   */
  private void parseParameters() {
    Node modelNode = doc.getLastChild();
    NodeList list = modelNode.getChildNodes();
    
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      if (node.getNodeName().equals("parameter")) {
        NamedNodeMap attr = node.getAttributes();
        String key = attr.item(0).getNodeValue();
        Double value = Double.valueOf(attr.item(1).getNodeValue());
        parameters.put(key, value);
      }
    }
  }
}
