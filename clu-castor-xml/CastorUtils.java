package com.calyon.util.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;

import com.calyon.util.ConversionUtils;

/**
 * Elements g�n�rique d'utilisation de CastorXML.
 *
 * @author C�drick LUNVEN
 */
public final class CastorUtils {

    /** Log statique pour la classe. * */
    private static final Log LOGGER = LogFactory.getLog(CastorUtils.class);

    /**
     * Suppression du constructeur par d�faut.
     */
    private CastorUtils() {
    }

    /**
     * Permet de convertir un bean en message String.
     *
     * @param bean
     *          objet a s�rialiser (doit etre genere par Castor)
     * @return
     *          l'objet sous forme de chaine de carac�res
     * @throws MarshalException
     *          Ettrut lors de la conversion
     * @throws ValidationException
     *          Erreur lors de la validation
     */
    public static String marshallToString(final Object bean)
    throws MarshalException, ValidationException {
        // L'objet Java est maintenant G�n�r� => Marshalling en XML
        ByteArrayOutputStream baos = (ByteArrayOutputStream) marshall(bean);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        String fichierXML = null;
        try {
            fichierXML = ConversionUtils.convertInputStreamToString(bais);
        } catch (IOException e) {
            LOGGER.debug("Erreur lors de la creation du fichier XML", e);
        } finally {
            LOGGER.debug("Sortie de la m�thode de cr�ation du XML pour le delai supplementaire");
        }
        return fichierXML;
    }

    /**
     * Conversion d'un bean en XML.
     *
     * @param pbeanCastor
     *          bean � convertir en stream.
     * @return
     *          flux serialiserdu bean
     * @throws MarshalException
     *          Ettrut lors de la conversion
     * @throws ValidationException
     *          Erreur lors de la validation
     */
    public static OutputStream marshall(final Object pbeanCastor)
    throws MarshalException, ValidationException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStreamWriter opsw = new OutputStreamWriter(out);
        try {
            Marshaller.marshal(pbeanCastor, opsw);
        } catch (MarshalException e) {
            LOGGER.debug("Impossible de r�aliser le XML : ", e);
            throw e;
        } catch (ValidationException e) {
            LOGGER.debug("Impossible de valider le XML : ", e);
            throw e;
        }
        return out;
    }

}
