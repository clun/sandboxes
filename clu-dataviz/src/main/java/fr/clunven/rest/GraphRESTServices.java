package fr.clunven.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.clunven.graph.d3.D3Graph;

@Path("/graph")
public class GraphRESTServices {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public D3Graph renderGraphAsD3() {
        D3Graph d3g = new D3Graph("Root");
        D3Graph child1 = new D3Graph("OTC");
        child1.addChild("IRD", 10);
        child1.addChild("CDS", 12);
        child1.addChild("FX", 14);
        child1.addChild("FXO", 17);
        d3g.addChild(child1);
        d3g.addChild("Listed", 20);
        return d3g;
    }
    
	
	
}
