package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    Button buttonUpdate;
    @FXML
    TextField textFieldMonth, textFieldProfit;
    @FXML
    TableColumn<Record, String> month;
    @FXML
    TableColumn<Record, Double> profit;


    @FXML
    CategoryAxis monthData; //x
    @FXML
    NumberAxis profitData; //y
    @FXML
    BarChart<String,Number> bar;// = new BarChart <String, Number>(monthData,profitData);
    @FXML
    TableView<Record> table;

    XYChart.Series series = new XYChart.Series();
    public void addToBarChart()
    {
        month.setCellValueFactory(new PropertyValueFactory<>("month"));
        profit.setCellValueFactory(new PropertyValueFactory<>("profit"));
    }


    public void update()
    {

        String varMonth=textFieldMonth.getText();
        Double varProfit = null;

        try
        {
            varProfit = Double.parseDouble(textFieldProfit.getText());
        }catch(NumberFormatException e)
        {
            System.out.println("NaN!");
        }

        addToBarChart();


        if(varProfit>=0 && varMonth.length()>0)
        {
            Record newRecord = new Record(varMonth,varProfit);
            table.getItems().add(newRecord);

            setGraph(varMonth,varProfit);
        }

        textFieldMonth.clear();
        textFieldProfit.clear();

    }
    public void setGraph(String month, Double profit)
    {
        series.getData().add(new XYChart.Data(month, profit));
        //monthData.setCategories(FXCollections.observableArrayList(month));
        bar.getData().add(series);
    }
}
