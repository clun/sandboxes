package fr.clunven.xsd;

import java.io.File;
import java.util.Iterator;

import org.junit.Test;

import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSContentType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSTerm;
import com.sun.xml.xsom.parser.XSOMParser;

public class XSDParserTest {

	@Test
	public void testParsingXSD() throws Exception {
		XSOMParser parser = new XSOMParser();
		parser.parse(new File("src/test/resources/rule-engine.xsd"));

		XSSchemaSet sset = parser.getResult();
		Iterator<XSSchema> itr = sset.iterateSchema();
		while (itr.hasNext()) {
			XSSchema s = itr.next();
			System.out.println("Target namespace: " + s.getTargetNamespace());

			Iterator<XSElementDecl> jtr = s.iterateElementDecls();
			while (jtr.hasNext()) {
				XSElementDecl e = jtr.next();
				System.out.println(e.getName() + ":");
				XSContentType xsContentType = e.getType().asComplexType().getContentType();
				XSParticle particle = xsContentType.asParticle();
				if (particle != null) {
					XSTerm term = particle.getTerm();
					if (term.isModelGroup()) {
						XSModelGroup xsModelGroup = term.asModelGroup();
						
						XSParticle[] particles = xsModelGroup.getChildren();
						String propertyName = null;
						String propertyType = null;
						for (XSParticle p : particles) {
							XSTerm pterm = p.getTerm();
							if (pterm.isElementDecl()) {
								propertyName = pterm.asElementDecl().getName();
								if (pterm.asElementDecl().getType().getName() == null) {
									propertyType = pterm.asElementDecl().getType().getBaseType().getName();
								} else {
									propertyType = pterm.asElementDecl().getType().getName();
								}
								System.out.println(e.getName() + " got a " + xsModelGroup.getCompositor() + " of " + propertyName + " (" + propertyType + ")");
							}
						}
					}
				}

				if (e.isAbstract())
					System.out.print(" (abstract)");
				System.out.println();
			}
			
			
			Iterator<XSComplexType> ctiter = s.iterateComplexTypes();
		    while (ctiter.hasNext()) {
		      XSComplexType ct =  ctiter.next();
		      String typeName = ct.getName();
		      String baseTypeName = ct.getBaseType().getName();
		      System.out.println(typeName + " is a " + baseTypeName);
		    }

		}

	}
}
