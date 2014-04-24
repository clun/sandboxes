<html>
<head>
    <title>Pie Charts and Options</title>
    <link class="include" rel="stylesheet" type="text/css" href="js/jqplot/jquery.jqplot.min.css" />
    <script class="include" type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>
    <script class="include" type="text/javascript" src="js/jqplot/jquery.jqplot.min.js"></script>
    <script class="include" type="text/javascript" src="js/jqplot/plugins/jqplot.pieRenderer.min.js"></script>
    <script class="include" type="text/javascript" src="js/jqplot/plugins/jqplot.barRenderer.min.js"></script>
	<script class="include" type="text/javascript" src="js/jqplot/plugins/jqplot.categoryAxisRenderer.min.js"></script>
	<script class="include" type="text/javascript" src="js/jqplot/plugins/jqplot.pointLabels.min.js"></script>
	<script class="include" type="text/javascript" src="js/jqplot/plugins/jqplot.bubbleRenderer.min.js"></script>
<style>
.divpie {
 margin-top:20px;
 margin-left:20px;
 width:500px;
 height:500px;
 padding:5px;
}
</style>
</head>
<body>

 <p id="info1"></p>
 <div id="chart1" class="divpie"></div>
    
	<script class="code" type="text/javascript">
	$(document).ready(function(){
		 
	    var arr = [[11, 123, 1236, "Acura"], [45, 92, 1067, "Alfa Romeo"], 
	    [24, 104, 1176, "AM General"], [50, 23, 610, "Aston Martin Lagonda"], 
	    [18, 17, 539, "Audi"], [7, 89, 864, "BMW"], [2, 13, 1026, "Bugatti"]];
	     
	    var plot1 = $.jqplot('chart1',[arr],{
	        title: 'Bubbles',
	        seriesDefaults:{
	            renderer: $.jqplot.BubbleRenderer,
	            rendererOptions: {
	                bubbleGradients: true
	            },
	            shadow: true
	        }
	    });
	    
	    $('#chart1').bind('jqplotDataClick', 
	            function (ev, seriesIndex, pointIndex, data) {
	    	
	                $('#info1').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
	            }
	        );
	});
	 </script>



<!-- End Don't touch this! -->

<!-- Additional plugins go here -->

 

</body>


</html>
