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
<style>
.divpie {
 margin-top:20px;
 margin-left:20px;
 width:200px;
 height:200px;
 padding:5px;
}
</style>
</head>
<body>

 <table>
 <tr>
 <td>
 <div id="chart1" class="divpie"></div>
    
	<script class="code" type="text/javascript">
	$(document).ready(function(){
        $.jqplot.config.enablePlugins = true;
        var s1 = [2, 6, 7, 10];
        var ticks = ['a', 'b', 'c', 'd'];
         
        plot1 = $.jqplot('chart1', [s1], {
        	title: 'Simple', 
            animate: !$.jqplot.use_excanvas,
            seriesDefaults:{
                renderer:$.jqplot.BarRenderer,
                pointLabels: { show: true }
            },
            axes: {
                xaxis: {
                    renderer: $.jqplot.CategoryAxisRenderer,
                    ticks: ticks
                }
            },
            highlighter: { show: false }
        });
     
        $('#chart1').bind('jqplotDataClick', 
            function (ev, seriesIndex, pointIndex, data) {
                $('#info1').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
            }
        );
    });
	 </script>
	</td>
	
 <td>
   <div id="chart2" class="divpie" ></div>
   
   <script class="code" type="text/javascript">
   $(document).ready(function(){
  var line1 = [14, 32, 41, 44, 40, 37, 29];
  var line2 = [7, 12, 15, 17, 20, 27, 39];
  var plot4 = $.jqplot('chart2', [line1, line2], {
      title: 'Cumulative', 
      stackSeries: true, 
      seriesDefaults: {
          renderer: $.jqplot.BarRenderer,
          rendererOptions:{barMargin: 25}, 
          pointLabels:{show:true, stackedValue: true}
      },
      axes: {
          xaxis:{renderer:$.jqplot.CategoryAxisRenderer}
      }
  });
});
   </script>
 </td>
 <td><div id="chart3" class="divpie" ></div></td>
</tr>
</table>




<!-- End Don't touch this! -->

<!-- Additional plugins go here -->

 

</body>


</html>
