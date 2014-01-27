package fr.clun.veille.restful.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 * @Produces : specifies the output format, I used the simplest one, other formats are for example: JSON and XML
 * @Path     : at class level specifies mapping which all methods will inherit
 * 
 * @GET - associates HTTP Method with annotated Java method, apart of
 *    @GET    - used for retrieving data
 *    @POST   - used for update operations
 *    @PUT    - used for create operations
 *    @DELETE - used for remove operations
 *
 */
@Path("/tokenid/{tokenid}")
@Produces("text/plain")
public class RESTProcessServices {

    @GET
    public String displayToken(@PathParam("tokenid") String token) {
        return "Identifiant de session " + token;
    }

    @GET
    @Path("/state/{state}")
    /** 
     * @Path("/state/{state}") - method level mapping, always concatenated with class level mapping,
     * in this case, complete mapping is: /name/{name}/state/{state}
     */
    public String sayHi(@PathParam("tokenid") String name, @PathParam("state") String state) {
        return displayToken(name) + " Do you like " + state + "?";
    }

    @GET
    @Path("/state/{state}/{params:.*}")
    /**
     * @Path("/state/{state}/{params:.*}") - {params:.*} is a placeholder representing
     * any number of dynamic parameters which adhere to the key/value pattern
     * 
     * when using {params:.*} pattern @PathParam
     * can convert parameters to a list of PathSegment objects
     */
    public String sayHi(@PathParam("tokenid") String name, @PathParam("state") String state,
            @PathParam("params") String paramsAsString, @PathParam("params") List < PathSegment > paramsAsList) {
        return sayHi(name, state) + " You like to pass params? " + paramsAsString;
    }
}
