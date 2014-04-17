<%@ taglib prefix="viz" uri="http://www.clunven.fr/viz" %>
<html>
<head>
    <script type="text/javascript" src="js/graphdracula/raphael-min.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graffle.js"></script>
    <script type="text/javascript" src="js/graphdracula/dracula_graph.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-1.4.2.js"></script>
</head>
<body>

<h2>TAG</H2>

<viz:graph divId="newGraph" 
	paramName="graph" 
	width="500" 
	height="300"
	cssStyle="border:1px solid blue"
	decorator="fr.clunven.viz.graphdracula.bam.CustomGraphDecorator">
</viz:graph>


</body>

</html>