package fr.clunven.viz.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.clunven.viz.domain.TreeNode;

@Path("/d3js")
public class D3DataServices {
	
	@GET
	@Path("/deals")
    @Produces(MediaType.APPLICATION_JSON)
    public TreeNode renderGraph4D3() {
        TreeNode d3g = new TreeNode("Root");
        TreeNode child1 = new TreeNode("OTC");
        child1.addChild("IRD", 10);
        child1.addChild("CDS", 12);
        child1.addChild("FX", 14);
        child1.addChild("FXO", 17);
        d3g.addChild(child1);
        
        TreeNode child2 = new TreeNode("Listed");
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
    public TreeNode renderGraphOCTO() {
        TreeNode d3g = new TreeNode("OCTO");
        
        TreeNode lobBA = new TreeNode("BA");
        lobBA.addChild("CLU", 10);
        lobBA.addChild("CDR", 10);
        lobBA.addChild("CRU", 10);
        lobBA.addChild("LBA", 10);
        lobBA.addChild("DAT", 10);
        lobBA.addChild("MBO", 10);
        lobBA.addChild("HTR", 10);
        d3g.addChild(lobBA);
        
        TreeNode lobSide = new TreeNode("SIDE");
        lobSide.addChild("MDO", 20);
        lobSide.addChild("IAN", 20);
        lobSide.addChild("DJO", 20);
        lobSide.addChild("JUK", 20);
        d3g.addChild(lobSide);
        
        TreeNode lobTime= new TreeNode("TIME");
        lobSide.addChild("DAL", 20);
        lobSide.addChild("MBA", 20);

        d3g.addChild(lobTime);
        
        
        
        return d3g;
    }
	
	
	

}
