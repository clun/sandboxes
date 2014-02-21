package fr.clunven.viz.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.clunven.viz.web.domain.D3TreeElement;

@Path("/d3js")
public class D3DataServices {
	
	@GET
	@Path("/deals")
    @Produces(MediaType.APPLICATION_JSON)
    public D3TreeElement renderGraph4D3() {
		
		
        D3TreeElement d3g = new D3TreeElement("Root");
        D3TreeElement child1 = new D3TreeElement("OTC");
        child1.addChild("IRD", 10);
        child1.addChild("CDS", 12);
        child1.addChild("FX", 14);
        child1.addChild("FXO", 17);
        d3g.addChild(child1);
        d3g.addChild("Listed", 20);
        return d3g;
    }

}
