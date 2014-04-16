package fr.clunven.viz.graphdracula;

import fr.clunven.domain.graph.Edge;
import fr.clunven.domain.graph.Vertex;

/**
 * Renderer of a graph.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public interface GraphDecorator {

    /**
     * Allow to override the default.
     * 
     * @return if not null overrride default
     */
    VertexStyle getDefaultVertexStyle();
	
    /**
     * Get vertexStyle from Vextex.
     * 
     * @param vertex
     *            current vertex
     * @return target style.
     */
    VertexStyle getVertexStyle(Vertex<?> vertex);
	
    /**
     * Sample Edge Style.
     * 
     * @param edge
     *            target edge
     * @return style
     */
    EdgeStyle getEdgeStyle(Edge<?> edge);

}
