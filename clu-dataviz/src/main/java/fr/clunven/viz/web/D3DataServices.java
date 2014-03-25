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
        
        D3TreeElement child2 = new D3TreeElement("Listed");
        child2.addChild("A", 20);
        child2.addChild("B", 20);
        child2.addChild("C", 20);
        child2.addChild("D", 20);
        d3g.addChild(child2);
        return d3g;
    }
	
	@GET
	@Path("/octo")
    @Produces(MediaType.APPLICATION_JSON)
    public D3TreeElement renderGraphOCTO() {
        D3TreeElement d3g = new D3TreeElement("OCTO");
        
        D3TreeElement lobBA = new D3TreeElement("BA");
        lobBA.addChild("CLU", 10);
        lobBA.addChild("CDR", 10);
        lobBA.addChild("CRU", 10);
        lobBA.addChild("LBA", 10);
        lobBA.addChild("DAT", 10);
        lobBA.addChild("MBO", 10);
        lobBA.addChild("HTR", 10);
        d3g.addChild(lobBA);
        
        D3TreeElement lobSide = new D3TreeElement("SIDE");
        lobSide.addChild("MDO", 20);
        lobSide.addChild("IAN", 20);
        lobSide.addChild("DJO", 20);
        lobSide.addChild("JUK", 20);
        d3g.addChild(lobSide);
        
        D3TreeElement lobTime= new D3TreeElement("TIME");
        lobSide.addChild("DAL", 20);
        lobSide.addChild("MBA", 20);

        d3g.addChild(lobTime);
        
        
        
        return d3g;
    }
	
	
	

}
