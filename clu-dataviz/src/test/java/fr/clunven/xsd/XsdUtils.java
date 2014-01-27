package fr.clunven.xsd;

import org.apache.xerces.xs.XSImplementation;
import org.apache.xerces.xs.XSLoader;
import org.apache.xerces.xs.XSModel;
import org.junit.Test;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import xsdvi.XsdHandler;
import xsdvi.svg.AbstractSymbol;
import xsdvi.svg.SymbolElement;
import xsdvi.utils.TreeBuilder;
import xsdvi.utils.TreeElement;
import xsdvi.utils.XsdErrorHandler;

public class XsdUtils {
	
	String xsdFile = "src/test/resources/rule-engine.xsd";
	
	@Test
	public void testParsingXSD() {
		XSLoader schemaLoader = getSchemaLoader();
		TreeBuilder tree = new TreeBuilder();
		XsdHandler xsdHandler = new XsdHandler(tree);
		XSModel model = schemaLoader.loadURI(xsdFile);
		xsdHandler.processModel(model);
		
		displayTree(0,tree.getRoot());
	}
	
	private void displayTree(int idx, TreeElement te) {
		for (int i = 0; i < idx; i++) {
			System.out.print(" ");
		}
		if (te instanceof SymbolElement) {
			SymbolElement se = (SymbolElement) te;
			System.out.println(se.getType());
		} else {
			System.out.println(((AbstractSymbol)te).code());
		}
		for (TreeElement tebis : te.getChildren()) {
			displayTree(idx++, tebis);
		}
	}
	
	/**
	 * @return
	 */
	private static XSLoader getSchemaLoader() {
		XSLoader schemaLoader = null;
		try {
			System.setProperty(DOMImplementationRegistry.PROPERTY, "org.apache.xerces.dom.DOMXSImplementationSourceImpl");
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			XSImplementation impl = (XSImplementation) registry.getDOMImplementation("XS-Loader");
			schemaLoader = impl.createXSLoader(null);
			DOMConfiguration config = schemaLoader.getConfig();
			DOMErrorHandler errorHandler = new XsdErrorHandler();
			config.setParameter("error-handler", errorHandler);
			config.setParameter("validate", Boolean.TRUE);
		} catch (ClassCastException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return schemaLoader;
	}
	

}
