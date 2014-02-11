
package fr.csf.ade;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.csf.ade package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ParticulierData_QNAME = new QName("http://www.csf.fr/ade", "ParticulierData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.csf.ade
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Retour }
     * 
     */
    public Retour createRetour() {
        return new Retour();
    }

    /**
     * Create an instance of {@link ParticulierData }
     * 
     */
    public ParticulierData createParticulierData() {
        return new ParticulierData();
    }

    /**
     * Create an instance of {@link GetParticulierResponse }
     * 
     */
    public GetParticulierResponse createGetParticulierResponse() {
        return new GetParticulierResponse();
    }

    /**
     * Create an instance of {@link Telephone }
     * 
     */
    public Telephone createTelephone() {
        return new Telephone();
    }

    /**
     * Create an instance of {@link Adresse }
     * 
     */
    public Adresse createAdresse() {
        return new Adresse();
    }

    /**
     * Create an instance of {@link ArrayOfTelephone }
     * 
     */
    public ArrayOfTelephone createArrayOfTelephone() {
        return new ArrayOfTelephone();
    }

    /**
     * Create an instance of {@link GetParticulier }
     * 
     */
    public GetParticulier createGetParticulier() {
        return new GetParticulier();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParticulierData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csf.fr/ade", name = "ParticulierData")
    public JAXBElement<ParticulierData> createParticulierData(ParticulierData value) {
        return new JAXBElement<ParticulierData>(_ParticulierData_QNAME, ParticulierData.class, null, value);
    }

}
