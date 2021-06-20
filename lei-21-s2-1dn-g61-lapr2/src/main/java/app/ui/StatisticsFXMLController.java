package app.ui;

import app.controller.StatisticsController;
import app.domain.model.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsFXMLController implements Initializable  {

    private StatisticsController sc;
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private TextField beginingDateText;

    @FXML
    private TextField endDateText;

    @FXML
    private BarChart<Integer, String> statisticsChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.sc = new StatisticsController();
        statisticsChart.setAnimated(false);
    }

    @FXML
    void dayGraphic(ActionEvent event) {
        statisticsChart.getData().clear();
        Date[] dates = datesToUse();
        if (dates != null) {
            if (validateDates(dates[0], dates[1])) {
                String[] daysText = sc.getDaysDate(dates[0], dates[1]);
                addDataBarChart(daysText, sc.getNumberTests(dates[0], daysText.length, "day", 2), sc.getNumberTests(dates[0], daysText.length, "day", 3), sc.getNumberTests(dates[0], daysText.length, "day", 4));
            }
        }
    }

    @FXML
    void weekGraphic(ActionEvent event) {
        statisticsChart.getData().clear();
        Date[] dates = datesToUse();
        if (dates != null) {
            if (validateDates(dates[0], dates[1])) {
                String[] weeksText = sc.getWeeksDate(dates[0], dates[1]);
                addDataBarChart(weeksText, sc.getNumberTests(dates[0], weeksText.length, "week", 2), sc.getNumberTests(dates[0], weeksText.length, "week", 3), sc.getNumberTests(dates[0], weeksText.length, "week", 4));
            }
        }
    }

    @FXML
    void monthGraphic(ActionEvent event) {
        statisticsChart.getData().clear();
        Date[] dates = datesToUse();
        if (dates != null) {
            if (validateDates(dates[0], dates[1])) {
                String[] monthsText = sc.getMonthsDate(dates[0], dates[1]);
                addDataBarChart(monthsText, sc.getNumberTests(dates[0], monthsText.length, "month", 2), sc.getNumberTests(dates[0], monthsText.length, "month", 3), sc.getNumberTests(dates[0], monthsText.length, "month", 4));
            }
        }
    }

    @FXML
    void yearGraphic(ActionEvent event) {
        statisticsChart.getData().clear();
        Date[] dates = datesToUse();
        if (dates != null) {
            if (validateDates(dates[0], dates[1])) {
                String[] yearsText = sc.getYearsDate(dates[0], dates[1]);
                addDataBarChart(yearsText, sc.getNumberTests(dates[0], yearsText.length, "year", 2), sc.getNumberTests(dates[0], yearsText.length, "year", 3), sc.getNumberTests(dates[0], yearsText.length, "year", 4));
            }
        }
    }

    @FXML
    void exit(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AnalyseOverview.fxml"));
            root = loader.load();
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addDataBarChart(String[] timeInterval, int[] numberTestsResult, int[] numberTestsDiagnose, int[] numberTestsProcessedLaboratory) {
        this.statisticsChart.getData().addAll(testsWaitingResult(timeInterval, numberTestsResult), testsWaitingDiagnose(timeInterval, numberTestsDiagnose), testsProcessedLaboratory(timeInterval, numberTestsProcessedLaboratory));
    }

    XYChart.Series testsWaitingResult(String[] timeInterval, int[] numberTestsResult) {
        XYChart.Series series = new XYChart.Series();
        series.setName("Tests Waiting For Result");
        for (int i = 0; i < timeInterval.length; i++) {
            series.getData().add(new XYChart.Data(timeInterval[i], numberTestsResult[i]));
        }
        return series;
    }

    XYChart.Series testsWaitingDiagnose(String[] timeInterval, int[] numberTestsDiagnose) {
        XYChart.Series series = new XYChart.Series();
        series.setName("Tests Waiting For Diagnose");
        for (int i = 0; i < timeInterval.length; i++) {
            series.getData().add(new XYChart.Data(timeInterval[i], numberTestsDiagnose[i]));
        }
        return series;
    }

    XYChart.Series testsProcessedLaboratory(String[] timeInterval, int[] numberTestsProcessedLaboratory) {
        XYChart.Series series = new XYChart.Series();
        series.setName("Tests Processed In Laboratory");
        for (int i = 0; i < timeInterval.length; i++) {
            series.getData().add(new XYChart.Data(timeInterval[i], numberTestsProcessedLaboratory[i]));
        }
        return series;
    }

    boolean correctDates() {
        if ((beginingDateText.getText().isEmpty()) || (endDateText.getText().isEmpty())) {
            return false;
        }
        return true;
    }

    Date[] datesToUse() {
        try {
            Date[] dates = new Date[2];
            if (correctDates()) {
                dates[0] = new Date(beginingDateText.getText());
                dates[1] = new Date(endDateText.getText());
            } else {
                createAlert(Alert.AlertType.WARNING, "Missing data", "Please insert the dates");
                return null;
                //dates = sc.firstAndLastDate();
            }
            return dates;
        } catch (NumberFormatException e) {
            createAlert(Alert.AlertType.WARNING, "Wrong date format", "The dates don't have the appropriate format (D/M/A).");
            return null;
        }
    }

    boolean validateDates(Date d1, Date d2) {
        if (d1.compareTo(d2) == 1) {
            createAlert(Alert.AlertType.WARNING, "Wrong dates", "The end date must be older than the beginning date.");
            return false;
        }
        return true;
    }

    void createAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
