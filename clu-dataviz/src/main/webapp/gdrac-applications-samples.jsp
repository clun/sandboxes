
<html>
<head>
    <script type="text/javascript" src="js/graphdracula/raphael-min.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graffle.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graph.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-1.4.2.js"></script>
</head>
<body>

<h1>Sample Process</h1>

<script>
  
  var redraw;
  window.onload = function() {
  var width  = 1000;
  var height = 500;
  var g        = new Graph();

 //rendu d'un noeud
 var renderGREEN = function(r, n) {
	var width = Math.max(n.label.length * 6 * 14/12, 60);
    var myRect   = r.rect(n.point[0]-width/2, n.point[1]-13, width, 44).attr({fill: "#080", r : "14px", stroke : "#ccc", "stroke-width" : "1px","fill-opacity":1 });
    var myText   = r.text(n.point[0], n.point[1] + 10, n.label).attr( {"fill": "#fff", "font-size": 14, "font-family": "Arial, Helvetica, sans-serif" });
    myRect.node.id = n.id;
    return r.set().push(myRect).push(myText);
 };
 
 //rendu d'un noeud
 var renderRED = function(r, n) {
	var width = Math.max(n.label.length * 6 * 14/12, 60);
	var myRect = r.rect(n.point[0]-width/2, n.point[1]-13, width, 44).attr({fill: "#800", r : "14px", stroke : "#ccc", "stroke-width" : "1px","fill-opacity":1 });
    var myText = r.text(n.point[0], n.point[1] + 10, n.label).attr( {"fill": "#fff", "font-size": 14, "font-family": "Arial, Helvetica, sans-serif" });
    var tips     = r.rect(n.point[0]+width/2, n.point[1]+21, 40, 20).attr({"fill": "#f80", "stroke-width": 0, "stroke": "#fff", r : "10px"});
    var tipsText = r.text(n.point[0]+width/2+20, n.point[1]+31, n.major || '0').attr( {"fill": "#FF1", "font-size": 14, "font-family": "Arial, Helvetica, sans-serif" });
    var tips2     = r.rect(n.point[0]+width/2, n.point[1], 40, 20).attr({"fill": "#F00", "stroke-width": 0, "stroke": "#eee", r : "10px"});
    var tipsText2 = r.text(n.point[0]+width/2+20, n.point[1]+10, n.severe|| '0').attr( {"fill": "#FFF", "font-size": 14, "font-family": "Arial, Helvetica, sans-serif" });
    var tips3     = r.rect(n.point[0]+width/2, n.point[1]-21, 40, 20).attr({"fill": "#000", "stroke-width": 0, "stroke": "#eee", r : "10px"});
    var tipsText3 = r.text(n.point[0]+width/2+20, n.point[1]-10, n.critical|| '0').attr( {"fill": "#FF1", "font-size": 14, "font-family": "Arial, Helvetica, sans-serif" });
    myRect.node.id = n.id;
    var set = r.set().push(myRect).push(myText).push(tips).push(tipsText).push(tips2).push(tipsText2).push(tips3).push(tipsText3);
    return set;
 };

 var renderEdgeGREEN = { 
	directed: true, 
	label : "ok",
	stroke : "#080",
	"label-style" : { "font-size": 12, "stroke": "#080" }
 };
 
   var renderEdgeRED = { 
	 directed: true, 
	 label : "ko",
	 stroke : "#800",
	 "label-style" : { "font-size": 12, "stroke": "#800" }
   };

   // All Edge become true
   g.edgeFactory.template.style.directed = true;
   g.addNode("A", { label : "applicationA", render:renderGREEN, x:1,y:2, cliquable:true } );
   g.addNode("B", { label : "applicationB", render:renderGREEN, x:2,y:1 } );
   g.addNode("C", { label : "applicationC", render:renderGREEN, x:2,y:2 } );
   g.addNode("D", { label : "applicationD", render:renderRED, 	x:3,y:2,critical:1,severe:2,major:10 } );
   g.addNode("E", { label : "applicationE", render:renderRED,   x:4,y:2,critical:2,severe:5 } );
   g.addNode("F", { label : "applicationF", render:renderRED,   x:5,y:2,major:3 } );
   g.addNode("G", { label : "applicationG", render:renderGREEN, x:2,y:3 } );
   g.addNode("H", { label : "applicationH", render:renderGREEN, x:6,y:2 } );
   g.addEdge("A", "B", renderEdgeGREEN);
   g.addEdge("A", "C", renderEdgeGREEN);
   g.addEdge("D", "E", renderEdgeRED);
   g.addEdge("E", "F", renderEdgeRED);
   g.addEdge("F", "H", renderEdgeRED);
   g.addEdge("G", "C", renderEdgeGREEN);
   g.addEdge("A", "G", renderEdgeGREEN);
   g.addEdge("A", "C", renderEdgeGREEN);
   g.addEdge("C", "D", renderEdgeGREEN);
   
   $("#A").live('click',function(){
	 alert('Click on A');
   });
   
  var layouter = new Graph.Layout.Fixed(g);
  var renderer = new Graph.Renderer.Raphael('mySampleGraph', g, width, height);

  redraw = function() {
     layouter.layout();
     renderer.draw();
  };
};
</script>
<div id="mySampleGraph" style="border : 1px solid blue;width:1010px"></div>
</body>

</html>