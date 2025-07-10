package ru.property;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author : faint
 * @date : 12.07.2023
 * @time : 15:41
 */
public class ConfigStoreFormatterXml extends ConfigStoreFormatterImpl {
    /**
     * Partial copy of java.util.XMLUtils.emitDocument(Document doc, OutputStream os, String encoding).
     * Re-implemented to avoid Properties keys auto-sort.
     * All exceptions are thrown through IOException exception.
     */
    @Override
    public String generate() throws IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException pe) {
            IOException e = new IOException();
            e.initCause(pe);
            throw e;
        }

        Document doc = db.newDocument();

        Element properties = (Element) doc.appendChild(doc.createElement("properties"));

        for (Map.Entry<String, String> pair : pairs.entrySet()) {
            Element entry = (Element) properties.appendChild(doc.createElement("entry"));
            entry.setAttribute("key", pair.getKey());
            entry.appendChild(doc.createTextNode(pair.getValue()));
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://java.sun.com/dtd/properties.dtd");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        } catch (TransformerConfigurationException tce) {
            IOException e = new IOException();
            e.initCause(tce);
            throw e;
        }

        DOMSource source = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult streamResult = new StreamResult(writer);

        try {
            transformer.transform(source, streamResult);
        } catch (TransformerException te) {
            IOException e = new IOException();
            e.initCause(te);
            throw e;
        }

        return writer.toString();
    }
}
