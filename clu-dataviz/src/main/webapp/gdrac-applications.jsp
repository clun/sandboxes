
<html>
<head>
    <script type="text/javascript" src="js/graphdracula/raphael-min.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graffle.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graph.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-1.4.2.js"></script>
</head>
<body>

<h1>Listing</h1>

<script>
  
  var redraw;
  window.onload = function() {
  var width  = 200;
  var height = 200;
  var g        = new Graph();

//rendu d'un noeud
  var renderGREEN = function(r, n) {
 	 var width = 80;
     var myRect   = r.rect(n.point[0]-width/2, n.point[1]-13, width, 80).attr({fill: "#080", r : "14px", stroke : "#ccc", "stroke-width" : "1px","fill-opacity":1 });
     var myText   = r.text(n.point[0], n.point[1] + 10, n.label).attr( {"fill": "#fff", "font-size": 14, "font-family": "Arial, Helvetica, sans-serif" });
     myRect.node.id = n.id;
     return r.set().push(myRect).push(myText);
  };
  
//rendu d'un noeud
  var renderRED = function(r, n) {
	  var width = 80;
	     var myRect   = r.rect(n.point[0]-width/2, n.point[1]-13, width, 80).attr({fill: "#800", r : "14px", stroke : "#ccc", "stroke-width" : "1px","fill-opacity":1 });
	     var myText   = r.text(n.point[0], n.point[1] + 10, n.label).attr( {"fill": "#fff", "font-size": 14, "font-family": "Arial, Helvetica, sans-serif" });
	     myRect.node.id = n.id;
	     return r.set().push(myRect).push(myText);
  };

   // All Edge become true
   g.edgeFactory.template.style.directed = true;
	
   g.addNode("P1",  { label : "Process1", 	render:renderGREEN, x:1,y:1,  cliquable:true} );
   g.addNode("P2", { label : "Process2", 	render:renderRED, x:2,y:1, cliquable:true  } );
   g.addNode("P3",  { label : "Process3", 	render:renderGREEN, x:1,y:2,  cliquable:true} );
   g.addNode("P4", { label : "Process4", 	render:renderRED, x:2,y:2, cliquable:true  } );
   $("#P1").live('click',function(){
	 window.open('gdrac-applications-samples.jsp');
   });
   $("#P2").live('click',function(){
		 window.open('gdrac-applications-samples.jsp');
	   });
   
  var layouter = new Graph.Layout.Fixed(g);
  var renderer = new Graph.Renderer.Raphael('mySampleGraph', g, width, height);

  redraw = function() {
     layouter.layout();
     renderer.draw();
  };
};
</script>
<div id="mySampleGraph" ></div>
</body>

</html>