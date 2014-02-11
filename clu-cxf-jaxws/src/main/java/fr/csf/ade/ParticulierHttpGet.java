package fr.csf.ade;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2.2
 * Mon Apr 12 16:11:34 CEST 2010
 * Generated source version: 2.2.2
 * 
 */
 
@WebService(targetNamespace = "http://www.csf.fr/ade", name = "ParticulierHttpGet")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ParticulierHttpGet {

    @WebResult(name = "ParticulierData", targetNamespace = "http://www.csf.fr/ade", partName = "Body")
    @WebMethod
    public ParticulierData getParticulier(
        @WebParam(partName = "numeroAdherent", name = "numeroAdherent", targetNamespace = "")
        java.lang.String numeroAdherent
    );
}
