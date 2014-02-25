<html>
<head>
    <title>Pie Charts and Options</title>
    <link class="include" rel="stylesheet" type="text/css" href="js/jqplot/jquery.jqplot.min.css" />
    <script class="include" type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>
    <script class="include" type="text/javascript" src="js/jqplot/jquery.jqplot.min.js"></script>
    <script class="include" type="text/javascript" src="js/jqplot/plugins/jqplot.pieRenderer.min.js"></script>
</head>
<body>
  
 <table>
 <tr>
 <td>
 <div id="pie1" style="margin-top:20px; margin-left:20px; width:200px; height:200px;"></div>
    
	<script class="code" type="text/javascript">
	 $(document).ready(function(){
	    var plot1 = $.jqplot('pie1', [[['a',25],['b',14],['c',7]]], {
	        gridPadding: {top:0, bottom:38, left:0, right:0},
	        seriesDefaults:{
	            renderer:$.jqplot.PieRenderer, 
	            trendline:{ show:false }, 
	            rendererOptions: { padding: 8, showDataLabels: true }
	        },
	        legend:{
	            show:true, 
	            placement: 'outside', 
	            rendererOptions: {
	                numberRows: 1
	            }, 
	            location:'s',
	            marginTop: '15px'
	        }       
	    });
	});</script>
	</td>
	

<td>
<div id="pie2" style="margin-top:20px; margin-left:20px; width:200px; height:200px;"></div>
</td>

<td>
    <div id="pie3" style="margin-top:20px; margin-left:20px; width:200px; height:200px;"></div>
</td>

</tr>
<tr>
<td>

    <div id="pie4" style="margin-top:20px; margin-left:20px; width:200px; height:200px;"></div>
</td>

<td>

    <div id="pie5" style="margin-top:20px; margin-left:20px; width:400px; height:240px;"></div>
    
    </td>

<td>
    <div id="pie6" style="margin-top:20px; margin-left:20px; width:400px; height:240px;"></div>
    </td>
    </tr>
    <tr>
    <td>

    <div id="pie7" style="margin-top:20px; margin-left:20px; width:400px; height:240px;"></div>
    
    </td>
    <td>

    <div id="pie8" style="margin-top:20px; margin-left:20px; width:300px; height:300px;"></div>
    </td>
    
    <td>
    ok
    </td>
    
    </tr>
    </table>
<script class="code" type="text/javascript">$(document).ready(function(){
    var plot2 = $.jqplot('pie2', [[['a',25],['b',14],['c',7]]], {
        seriesDefaults:{ renderer:$.jqplot.PieRenderer, trendline:{ show: true } },
        legend:{ show: true }    
    });
});</script>

<script class="code" type="text/javascript">$(document).ready(function(){    
    var plot3 = $.jqplot('pie3', [[['a',1],['b',9],['c',1]]], {
        seriesDefaults:{
            shadow: false, 
            renderer:$.jqplot.PieRenderer, 
            rendererOptions:{
                sliceMargin: 4, 
                // rotate the starting position of the pie around to 12 o'clock.
                startAngle: -90
            }
        },
        legend:{ show: true }      
    });
});</script>
 
<script class="code" type="text/javascript">$(document).ready(function(){   
    var plot4 = $.jqplot('pie4', [[["a",0],["b",1],["c",.01]]], {
        seriesDefaults:{
            renderer:$.jqplot.PieRenderer, 
            rendererOptions:{ sliceMargin: 0 }
        },
        legend:{ show: true }      
    });
});</script> 
  
<script class="code" type="text/javascript">$(document).ready(function(){  
    var plot5 = $.jqplot('pie5', [[["none",23],["error",0],["click",5],["impression",25]]], {
        seriesDefaults:{ renderer: $.jqplot.PieRenderer },
        legend:{ show:true }      
    });   
});</script>
  
<script class="code" type="text/javascript">$(document).ready(function(){  
    var plot6 = $.jqplot('pie6', [[["none",0],["error",0],["click",0],["impression",0]]], {
        seriesDefaults:{ renderer: $.jqplot.PieRenderer },
        legend:{ show:true }     
    });   
});</script>
  
<script class="code" type="text/javascript">$(document).ready(function(){  
    var plot7 = $.jqplot('pie7', [[["all", 10]]], {
        seriesDefaults:{
            renderer:$.jqplot.PieRenderer,
            rendererOptions: {
                showDataLabels: true
            }
        },
        legend:{show:true}      
    });   
});</script>
  
<script class="code" type="text/javascript">$(document).ready(function(){ 
    var s1 = [['Sony',7], ['Samsumg',13.3], ['LG',14.7], ['Vizio',5.2], ['Insignia', 1.2]];
        
    var plot8 = $.jqplot('pie8', [s1], {
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
});</script>


<!-- End Don't touch this! -->

<!-- Additional plugins go here -->

 

</body>


</html>
