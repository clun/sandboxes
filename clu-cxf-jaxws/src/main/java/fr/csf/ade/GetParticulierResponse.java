
package fr.csf.ade;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getParticulierResult" type="{http://www.csf.fr/ade}ParticulierData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getParticulierResult"
})
@XmlRootElement(name = "getParticulierResponse")
public class GetParticulierResponse {

    protected ParticulierData getParticulierResult;

    /**
     * Gets the value of the getParticulierResult property.
     * 
     * @return
     *     possible object is
     *     {@link ParticulierData }
     *     
     */
    public ParticulierData getGetParticulierResult() {
        return getParticulierResult;
    }

    /**
     * Sets the value of the getParticulierResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticulierData }
     *     
     */
    public void setGetParticulierResult(ParticulierData value) {
        this.getParticulierResult = value;
    }

}
