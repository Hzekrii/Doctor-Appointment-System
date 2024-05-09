package utils;

import Controllers.DoctorController;
import Controllers.PatientController;
import Models.Doctor;
import Views.Secretary.pages.Patients;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

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
                StreamResult result = new StreamResult(fileToSave + ".xml");
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

    public static void importXMLFile(String nodesTitle){
        try {
            // Prompt the user to select a file to import
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);

                NodeList nodes = document.getElementsByTagName(nodesTitle);

                JOptionPane.showMessageDialog(null, "Import finished with success!");
                if (nodes.getLength() > 0) {
                    importDataToDb(nodes, nodesTitle);
                } else {
                    JOptionPane.showMessageDialog(null, "No elements found with the specified title.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Import failed!");
        }
    }

    public static void importDataToDb(NodeList nodelist, String whichController){
        int length = nodelist.getLength();
        for(int i = 0; i < length; i++){
            Node node = nodelist.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                switch(whichController){
                    case "patient":
                        PatientController.createPatient(
                                element.getElementsByTagName("cin").item(0).getTextContent(),
                                element.getElementsByTagName("first_name").item(0).getTextContent(),
                                element.getElementsByTagName("last_name").item(0).getTextContent(),
                                element.getElementsByTagName("email").item(0).getTextContent(),
                                element.getElementsByTagName("telephone").item(0).getTextContent()
                        );
                        break;
                    case "doctor":
                        DoctorController.createDoctor(
                                element.getElementsByTagName("cin").item(0).getTextContent(),
                                element.getElementsByTagName("first_name").item(0).getTextContent(),
                                element.getElementsByTagName("last_name").item(0).getTextContent(),
                                element.getElementsByTagName("email").item(0).getTextContent(),
                                element.getElementsByTagName("telephone").item(0).getTextContent(),
                                Doctor.DoctorSpecialty.valueOf(element.getElementsByTagName("speciality").item(0).getTextContent()),
                                Integer.parseInt(element.getElementsByTagName("registration_num").item(0).getTextContent())
                        );
                        break;
                }
            }
        }
    }
}
