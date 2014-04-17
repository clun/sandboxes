package fr.clunven.viz.graphdracula.bam;

import fr.clunven.domain.graph.Edge;
import fr.clunven.domain.graph.Vertex;
import fr.clunven.viz.graphdracula.EdgeStyle;
import fr.clunven.viz.graphdracula.GraphDecorator;
import fr.clunven.viz.graphdracula.VertexStyle;

/**
 * Sample of decorator to override defaut behavior.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class CustomGraphDecorator implements GraphDecorator {
	
    /** Sample RED. */
	private VertexStyle redVS = null;
	
    /** {@inheritDoc} */
	@Override
	public VertexStyle getDefaultVertexStyle() {
        return null;
	}

    /** {@inheritDoc} */
	@Override
    public VertexStyle getVertexStyle(Vertex<?> vertex) {
        if (redVS == null) {
			redVS = new VertexStyle();
			redVS.getFont().setColor("#f00");
		}
        return vertex.getLabel().contains("????") ? redVS : vertex.getStyle();
	}

    /** {@inheritDoc} */
	@Override
    public EdgeStyle getEdgeStyle(Edge<?> edge) {
		return new EdgeStyle();
	}
	

}
