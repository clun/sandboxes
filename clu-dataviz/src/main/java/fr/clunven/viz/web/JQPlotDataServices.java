package fr.clunven.viz.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.clunven.viz.domain.BarChartData;
import fr.clunven.viz.domain.BubbleChartData;
import fr.clunven.viz.domain.PieChartData;
import fr.clunven.viz.domain.PointData;

@Path("/jqplot")
public class JQPlotDataServices {
    
    @GET
    @Path("/pie")
    @Produces(MediaType.APPLICATION_JSON)
    public PieChartData getMockPieChart() {
        PieChartData pc = new PieChartData();
        pc.getSeries().put("Banane", 10d);
        pc.getSeries().put("Orange", 20d);
        pc.getSeries().put("Carrotes", 50d);
        return pc;
    }

    @GET
    @Path("/bubble")
    @Produces(MediaType.APPLICATION_JSON)
    public BubbleChartData getMockBubbleChart() {
        BubbleChartData bpd = new BubbleChartData();
        bpd.getSeries().put("Banane", new PointData(1, 1, 10));
        bpd.getSeries().put("Orange", new PointData(2, 2, 10));
        bpd.getSeries().put("Carrotes", new PointData(3, 3, 10));
        return bpd;
    }

    @GET
    @Path("/bar")
    @Produces(MediaType.APPLICATION_JSON)
    public BarChartData getMockBarChart() {
        BarChartData bcd = new BarChartData();
        return bcd;
    }

}
