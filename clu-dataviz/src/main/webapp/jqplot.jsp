<html>
<head>
  <script type="text/javascript" src="js/jqplot/jquery.jqplot.min.js"></script>
  <script type="text/javascript" src="js/jqplot/plugins/jqplot.pieRenderer.min.js"></script>
  <script type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>

  <link class="include" rel="stylesheet" type="text/css" href="js/jqplot/jquery.jqplot.min.css" />
	
</head>
<body>
        
	<style type="text/css">
.jqplot-target {
	margin-bottom: 2em;
}

.note {
	font-size: 0.8em;
}

#tooltip1b {
	font-size: 12px;
	color: rgb(15%, 15%, 15%);
	padding: 2px;
	background-color: rgba(95%, 95%, 95%, 0.8);
}

#legend1b {
	font-size: 12px;
	border: 1px solid #cdcdcd;
	border-collapse: collapse;
}

#legend1b td,#legend1b th {
	border: 1px solid #cdcdcd;
	padding: 1px 4px;
}
</style>

	<div id="chart1" class="plot"
		style="width: 460px; height: 340px; border: 1px solid red"></div>

	<script class="code" language="javascript" type="text/javascript">
  $(document).ready(function(){ 
	    var s1 = [['Sony',7], ['Samsumg',13.3], ['LG',14.7], ['Vizio',5.2], ['Insignia', 1.2]];
	         
	    var plot8 = $.jqplot('chart1', [s1], {
	        grid: {
	            drawBorder: false, 
	            drawGridlines: false,
	            background: '#ffffff',
	            shadow:false
	        },
	        axesDefaults: {
	             
	        },
	        seriesDefaults:{
	            renderer:$.jqplot.PieRenderer,
	            rendererOptions: {
	                showDataLabels: true
	            }
	        },
	        legend: {
	            show: true,
	            rendererOptions: {
	                numberRows: 1
	            },
	            location: 's'
	        }
	    }); 
	});
  
  </script>
  
  <script type="text/javascript" src="js/jqplot/syntaxhighligh/scripts/shCore.min.js"></script>
  <script type="text/javascript" src="js/jqplot/syntaxhighligh/scripts/shBrushJScript.min.js"></script>
  <script type="text/javascript" src="js/jqplot/syntaxhighligh/scripts/shBrushXml.min.js"></script>
  

</body>
</html>

