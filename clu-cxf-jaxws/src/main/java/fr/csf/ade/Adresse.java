
package fr.csf.ade;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Adresse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Adresse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroVoie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indiceRepetition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeVoie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomVoie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="complement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codePostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adresse", propOrder = {
    "numeroVoie",
    "indiceRepetition",
    "typeVoie",
    "nomVoie",
    "complement",
    "codePostal",
    "ville",
    "pays"
})
public class Adresse {

    protected String numeroVoie;
    protected String indiceRepetition;
    protected String typeVoie;
    protected String nomVoie;
    protected String complement;
    protected String codePostal;
    protected String ville;
    protected String pays;

    /**
     * Gets the value of the numeroVoie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroVoie() {
        return numeroVoie;
    }

    /**
     * Sets the value of the numeroVoie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroVoie(String value) {
        this.numeroVoie = value;
    }

    /**
     * Gets the value of the indiceRepetition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndiceRepetition() {
        return indiceRepetition;
    }

    /**
     * Sets the value of the indiceRepetition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndiceRepetition(String value) {
        this.indiceRepetition = value;
    }

    /**
     * Gets the value of the typeVoie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeVoie() {
        return typeVoie;
    }

    /**
     * Sets the value of the typeVoie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeVoie(String value) {
        this.typeVoie = value;
    }

    /**
     * Gets the value of the nomVoie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomVoie() {
        return nomVoie;
    }

    /**
     * Sets the value of the nomVoie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomVoie(String value) {
        this.nomVoie = value;
    }

    /**
     * Gets the value of the complement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplement() {
        return complement;
    }

    /**
     * Sets the value of the complement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplement(String value) {
        this.complement = value;
    }

    /**
     * Gets the value of the codePostal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Sets the value of the codePostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostal(String value) {
        this.codePostal = value;
    }

    /**
     * Gets the value of the ville property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVille() {
        return ville;
    }

    /**
     * Sets the value of the ville property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVille(String value) {
        this.ville = value;
    }

    /**
     * Gets the value of the pays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPays() {
        return pays;
    }

    /**
     * Sets the value of the pays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPays(String value) {
        this.pays = value;
    }

}
