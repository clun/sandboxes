
package fr.csf.ade;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ParticulierData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParticulierData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="civilite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomDeNaissance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateNaissance" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="codePostalNaissance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lieuNaissance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adresse" type="{http://www.csf.fr/ade}Adresse" minOccurs="0"/>
 *         &lt;element name="telephones" type="{http://www.csf.fr/ade}ArrayOfTelephone" minOccurs="0"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="retour" type="{http://www.csf.fr/ade}Retour" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParticulierData", propOrder = {
    "numero",
    "civilite",
    "nom",
    "prenom",
    "nomDeNaissance",
    "dateNaissance",
    "codePostalNaissance",
    "lieuNaissance",
    "adresse",
    "telephones",
    "mail",
    "retour"
})
public class ParticulierData {

    protected String numero;
    protected String civilite;
    protected String nom;
    protected String prenom;
    protected String nomDeNaissance;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateNaissance;
    protected String codePostalNaissance;
    protected String lieuNaissance;
    protected Adresse adresse;
    protected ArrayOfTelephone telephones;
    protected String mail;
    protected Retour retour;

    /**
     * Gets the value of the numero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Gets the value of the civilite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCivilite() {
        return civilite;
    }

    /**
     * Sets the value of the civilite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCivilite(String value) {
        this.civilite = value;
    }

    /**
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Gets the value of the prenom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets the value of the prenom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Gets the value of the nomDeNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomDeNaissance() {
        return nomDeNaissance;
    }

    /**
     * Sets the value of the nomDeNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomDeNaissance(String value) {
        this.nomDeNaissance = value;
    }

    /**
     * Gets the value of the dateNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Sets the value of the dateNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateNaissance(XMLGregorianCalendar value) {
        this.dateNaissance = value;
    }

    /**
     * Gets the value of the codePostalNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostalNaissance() {
        return codePostalNaissance;
    }

    /**
     * Sets the value of the codePostalNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostalNaissance(String value) {
        this.codePostalNaissance = value;
    }

    /**
     * Gets the value of the lieuNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    /**
     * Sets the value of the lieuNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLieuNaissance(String value) {
        this.lieuNaissance = value;
    }

    /**
     * Gets the value of the adresse property.
     * 
     * @return
     *     possible object is
     *     {@link Adresse }
     *     
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Sets the value of the adresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresse }
     *     
     */
    public void setAdresse(Adresse value) {
        this.adresse = value;
    }

    /**
     * Gets the value of the telephones property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTelephone }
     *     
     */
    public ArrayOfTelephone getTelephones() {
        return telephones;
    }

    /**
     * Sets the value of the telephones property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTelephone }
     *     
     */
    public void setTelephones(ArrayOfTelephone value) {
        this.telephones = value;
    }

    /**
     * Gets the value of the mail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the value of the mail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMail(String value) {
        this.mail = value;
    }

    /**
     * Gets the value of the retour property.
     * 
     * @return
     *     possible object is
     *     {@link Retour }
     *     
     */
    public Retour getRetour() {
        return retour;
    }

    /**
     * Sets the value of the retour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Retour }
     *     
     */
    public void setRetour(Retour value) {
        this.retour = value;
    }

}
