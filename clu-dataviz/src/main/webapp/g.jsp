
<html>
<head>
    <script type="text/javascript" src="js/graphdracula/raphael-min.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graffle.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graph.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-1.4.2.js"></script>
</head>
<body>

<p>Et voila</p>

<script>
var redraw;
window.onload = function() {
  var width  = $(document).width() - 200;
  var height = $(document).height() - 200;
  var g        = new Graph();

 

//rendu d'un noeud
var render2 = function(r, n) {
	var fwidth = Math.max(n.label.length * 6 * 14/12, 60);
    var set = r.set();       
    set.push(
    r.rect(n.point[0]-fwidth/2, n.point[1]-13, fwidth, 44).attr({"fill": "#000", r : "14px", "stroke" : "#ccc", "stroke-width" : "2px" })).push(
    r.text(n.point[0], n.point[1] + 10, n.label).attr( {"stroke": "#fff", "font-size": 14, "font-family": "Arial, Helvetica, sans-serif" }));       
    return set;
};


   g.addNode("A", { label : "A", render:render2 } );
   g.addNode("B", { label : "B", render:render2 } );
   g.addNode("C", { label : "C", render:render2 } );
   g.addNode("D", { label : "D", render:render2 } );
   g.addNode("E", { label : "E", render:render2 } );
   g.addNode("strawberry");
   g.addEdge("A", "B");
   g.addEdge("A", "C");
   g.addEdge("A", "D");
   g.addEdge("C", "E");
   g.addEdge("D", "E");
  var layouter = new Graph.Layout.Spring(g);
  var renderer = new Graph.Renderer.Raphael('mySampleGraph', g, width, height);

  redraw = function() {
     layouter.layout();
     renderer.draw();
  };
};
</script>
<div id="mySampleGraph"></div>



</body>

</html>