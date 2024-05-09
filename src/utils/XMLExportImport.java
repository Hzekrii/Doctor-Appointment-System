package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLExportImport {

    public static void exportToXml(JTable table, String xmlRootElement, String parentElement) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new Document
            Document document = builder.newDocument();

            // Create root element
            Element rootElement = document.createElement(xmlRootElement);
            document.appendChild(rootElement);

            for(int i = 0; i < table.getRowCount(); i++){
                Element element = createElement(document, table, i, parentElement);
                rootElement.appendChild(element);
            }

            // Allow the user to choose the path to save the file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose a location to save the file");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                // Write the document content to a file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                // Enable indentation
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(fileToSave);
                transformer.transform(source, result);
            }


            System.out.println("XML file saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Element createElement(Document document, JTable table, int rowNum, String parentElementTitle) {
        // Create employee element
        Element parentElement = document.createElement(parentElementTitle);

        for(int i = 0; i < table.getColumnCount() - 2; i++){
            // Add name element
            Element nameElement = document.createElement(table.getColumnName(i).trim().replace(" ", "_").toLowerCase());
            nameElement.appendChild(document.createTextNode(table.getValueAt(rowNum, i).toString().trim().replace(" ", "_")));
            parentElement.appendChild(nameElement);
        }
        return parentElement;
    }
}
