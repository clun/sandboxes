<html>
<head>
    <script type="text/javascript" src="js/graphdracula/raphael-min.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graffle.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graph.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-1.4.2.js"></script>
</head>
<body>

<script>
var redraw;

window.onload = function() {
	 
    var width  = $(document).width() - 20;
    var height = $(document).height() - 60;
 
    // rendu d'un noeud
    var render = function(r, n) {
        var set = r.set().push(
        r.rect(n.point[0]-30, n.point[1]-13, 60, 44).attr({"fill": "#feb", r : "12px", "stroke-width" : n.distance == 0 ? "3px" : "1px" })).push(
        r.text(n.point[0], n.point[1] + 10, (n.label || n.id) + "\n(" + ("FO") + ")"));      
        return set;
    };
   
    // rendu d'un noeud
    var render2 = function(r, n) {
    	var width = Math.max(n.label.length * 6 * 14/12, 60);
        var set = r.set();       
        set.push(
        r.rect(n.point[0]-width/2, n.point[1]-13, width, 44).attr({"fill": "#000", r : "14px", "stroke" : "#ccc", "stroke-width" : "2px" })).push(
        r.text(n.point[0], n.point[1] + 10, n.label).attr( {"stroke": "#fff", "font-size": 14, "font-family": "Arial, Helvetica, sans-serif" }));       
        return set;
    };
    
    var render3 = function(r, n) {
        var set = r.set().push(
            r.rect(n.point[0]-30, n.point[1]-13, 62, 86)
            	.attr({"fill": "#fa8", "stroke-width": 2, r : "9px"}))
                .push(r.text(n.point[0], n.point[1] + 30, n.label)
                    .attr({"font-size":"20px"}));
        /* custom tooltip attached to the set */
        set.items.forEach(
            function(el) {
                el.tooltip(r.set().push(r.rect(0, 0, 30, 30)
                    .attr({"fill": "#fec", "stroke-width": 1, r : "9px"})))});
        return set;
    };
    
    var render4 = function(r, n) {
        var set = r.set();
        set.push( r.image("img/sort_asc.png", 10, 10, 80, 80));
        return set;
    };
    
    var render6 = function(r, n) { return  r.set().push( r.image("img/sort_asc.png", 10, 10, 80, 80)); };
    
    // rendu d'un noeud
    var render5 = function(r, n) {
        var set = r.set();       
        set.push(
        r.rect(n.point[0]-30, n.point[1]-13, n.label.length*10, 44).
        	attr({"fill": "#56f", r : "12px", "stroke-width" : n.distance == 0 ? "3px" : "1px" })).push(
        r.text(n.point[0], n.point[1] + 10, n.label));       
        return set;
    };
      
       // notre Graphe
    var g = new Graph();

    /* add a simple node */
    g.addNode("strawberry");
    
    g.addNode("simple-click", { label : "simple-click"} );
    $("#simple-click").live('click', function() {
    	alert('Vous avez cliquer sur ' + this.id); 
     });
    
    
    g.addNode("hello", { label : "hello" , render:render2} );
    g.addNode("aaa", { label : "aa" , render: function(r, n) { return r.set().push( r.image("img/sort_asc.png", 10, 10, 80, 80)); }} );
    
    g.addNode("double-click", { label : "il faut se faire une raison" , render:render2} );
    g.addNode("gus", { label : "coucou tout le monde je suis le roi du monde" , render:render2} );
    
    
    g.addEdge("hello", "double-click");
    g.addEdge("hello", "gus");
    g.addEdge("gus", "double-click");
     
    
    
    $("#double-click").live('dblclick', function() {
    	alert('Vous avez double-cliquer sur ' + this.id); 
     });
    
    //var edgeRender = { directed: true, "label-style" : { "font-size": 12 } };
    //g.addEdge("simple-click", "double-click", edgeRender);
    //g.addEdge("double-click", "simple-click", edgeRender);
    
    
    
    
    /* add a node with a customized label */
    g.addNode("coucou", { label : "Tomato", render:render4});
   
    
    g.addNode("id35", {
        label : "meat\nand\ngreed" ,
 		render : render3
    });

    st = { directed: true, label : "Label", "label-style" : { "font-size": 20 } };
    g.addEdge("kiwi", "penguin", st);

    /* connect nodes with edges */
    g.addEdge("strawberry", "cherry");
    g.addEdge("cherry", "apple");
    g.addEdge("cherry", "apple")
    g.addEdge("coucou", "id35");
    g.addEdge("penguin", "id35");
    g.addEdge("penguin", "apple");
    g.addEdge("kiwi", "id35");

    /* a directed connection, using an arrow */
    g.addEdge("1", "cherry", { directed : true } );
    
    /* customize the colors of that edge */
    g.addEdge("id35", "apple", { stroke : "#bfa" , fill : "#56f", label : "Meat-to-Apple" });
    
    /* add an unknown node implicitly by adding an edge */
    g.addEdge("strawberry", "apple");

 
   /* layout the graph using the Spring layout implementation */
    var layouter = new Graph.Layout.Spring(g);
 
    var renderer = new Graph.Renderer.Raphael('canvas', g, width, height);
 
    redraw = function() {
        layouter.layout();
        renderer.draw();
    };
    
    
    
};
</script>




<div id="canvas"></div>

<script>

</script>

<button id="redraw" onclick="redraw();">redraw</button>
</body>
</html>
