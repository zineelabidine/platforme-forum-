package controler;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;



@ManagedBean
public class ChartView implements Serializable {
	private static final long serialVersionUID = 1L;
	private BarChartModel barModel;
    @PostConstruct
    public void init() {
        createBarModels();
    }
    public BarChartModel getBarModel() {
        return barModel;
    }
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries user = new ChartSeries();
        user.setLabel("Nombre des users");
        user.set("Etat du forum", tools.tools.nomberuser());
        ChartSeries categorie = new ChartSeries();
        categorie.setLabel("Nombre des categorie");
        categorie.set("categorie", tools.tools.nombercategorie());
        ChartSeries forum = new ChartSeries();
        forum.setLabel("Nombre des forum");
        forum.set("forum", tools.tools.nomberforum());
        ChartSeries discussion = new ChartSeries();
        discussion.setLabel("Nombre des discussion");
        discussion.set("fidcussion", tools.tools.nomberdiscussion());
        ChartSeries message = new ChartSeries();
        message.setLabel("Nombre des discussion");
        message.set("discussion", tools.tools.nombermessage());
        model.addSeries(user);
        model.addSeries(categorie);
        model.addSeries(forum);
        model.addSeries(discussion);
        model.addSeries(message);
        return model;
    }
    private void createBarModels() {
        createBarModel();
    }
    private void createBarModel() {
        barModel = initBarModel();
        barModel.setTitle("Etat du forum");
        barModel.setLegendPosition("ne");
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("chiffre");
        yAxis.setMin(0);
        yAxis.setMax(60);
    }
	 
}