package fr.clunven.viz.graphdracula.bam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.clunven.domain.graph.Edge;
import fr.clunven.domain.graph.Graph;
import fr.clunven.domain.graph.Vertex;
import fr.clunven.viz.graphdracula.DisplayFont;
import fr.clunven.viz.graphdracula.VertexStyle;

public class BAMGraphBuilder {
    
    private BAMGraphBuilder() {}

    /**
     * Sample creating Graph.
     *
     * @return
     *      sample creating graph
     */
    public static Graph<?, ?> getGraph() {
        Graph<List < BAMAlert >, Integer> myGraph = new Graph<List < BAMAlert >, Integer>();
        myGraph.setDirected(true);

        // STYLE APPLICATION EN ERREUR EN ROUGE
        VertexStyle styleAppInError = new VertexStyle();
        DisplayFont fontError = new DisplayFont();
        fontError.setColor("#ccc");
        styleAppInError.setFillColor("#800");
        styleAppInError.setBorderColor("#ccc");
        styleAppInError.setFont(fontError);
        
        // STYLE APPLICATION OK EN VERT
        VertexStyle styleAppOK= new VertexStyle();
        styleAppOK.setFillColor("#080");
        styleAppOK.setBorderColor("#ccc");
       
        // NOEUD APP1
        List<BAMAlert> app1Alerts = new ArrayList<BAMAlert>();
        app1Alerts.add(new BAMAlert("missing_deals", "sample application", "biz1"));
        app1Alerts.add(new BAMAlert("jump", "sample application", "biz1"));
        Vertex<List<BAMAlert>> vApp1 = new Vertex<List<BAMAlert>>("sample application", app1Alerts, 1, 1);
        myGraph.addVertex(vApp1, styleAppInError);

        myGraph.addVertex(getSimpleVertex("app2", 2, 1), styleAppOK);
        myGraph.addVertex(getSimpleVertex("C", 2, 2), styleAppOK);
        myGraph.addVertex(getSimpleVertex("D", 2, 3), styleAppOK);
        myGraph.addVertex(getSimpleVertex("E", 3, 2), styleAppOK);

        // Edges
        myGraph.addEdge(new Edge<Integer>("sample application", "app2"));
        myGraph.addEdge(new Edge<Integer>("sample application", "C"));
        myGraph.addEdge(new Edge<Integer>("sample application", "D"));
        myGraph.addEdge(new Edge<Integer>("C", "E"));
        myGraph.addEdge(new Edge<Integer>("D", "E"));

        return myGraph;
    }
    
    private static Vertex<List<BAMAlert>> getSimpleVertex(String label, int x, int y) {
        return new Vertex<List<BAMAlert>>(label, new ArrayList<BAMAlert>(), x, y);
    }
    
    /**
     * 
     * @param businessChain
     * @return
     */
    public static Map<String, List<String>> getAlerts(String businessChain) {
        Map<String, List<String>> mapOfAlerts = new HashMap<String, List<String>>();

        return mapOfAlerts;

    }

}
