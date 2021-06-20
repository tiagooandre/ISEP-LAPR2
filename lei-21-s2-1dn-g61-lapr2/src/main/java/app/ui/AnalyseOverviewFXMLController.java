package app.ui;

import app.controller.AnalyseOverviewController;
import app.domain.model.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnalyseOverviewFXMLController implements Initializable  {

    @FXML
    private ChoiceBox<String> selectAlgorithm;

    @FXML
    private TextField dateSequenceText;

    @FXML
    private TextField beginingDateText;

    @FXML
    private TextField endDateText;

    @FXML
    private TextField testsProcessedtxt;

    @FXML
    private TextField clientstxt;

    private AnalyseOverviewController analyseController;

    private Parent root;

    private Stage stage;

    private Scene scene;

    private final String ALGORITHM1 = "Benchmark algorithm";
    private final String ALGORITHM2 = "Brute-force algorithm";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.analyseController = new AnalyseOverviewController();
        selectAlgorithm.getItems().add(ALGORITHM1);
        selectAlgorithm.getItems().add(ALGORITHM2);
    }

    @FXML
    void numberClients(ActionEvent event) {
        clientstxt.setText(String.valueOf(analyseController.getNumberClients()));
    }

    @FXML
    void numberTestsProcessed(ActionEvent event) {
        testsProcessedtxt.setText(String.valueOf(analyseController.getTestsProcessed()));
    }

    @FXML
    void subSequence(ActionEvent event) {
        try {
            if ((beginingDateText.getText().isEmpty()) || (endDateText.getText().isEmpty())) {
                createAlert(Alert.AlertType.WARNING, "Missing data", "Please insert the dates");
            } else {
                if (selectAlgorithm.getValue() == null) {
                    createAlert(Alert.AlertType.WARNING, "Algorithm is not selected", "Please select an algorithm.");
                } else {
                    switch (selectAlgorithm.getSelectionModel().getSelectedItem()) {
                        case ALGORITHM1:
                            Date beginningDate = new Date(beginingDateText.getText());
                            Date endDate = new Date(endDateText.getText());
                            if (beginningDate.compareTo(endDate) != 1) {
                                dateSequenceText.setText(analyseController.calculatesInterval(beginningDate, endDate));
                            } else {
                                createAlert(Alert.AlertType.WARNING, "Wrong dates", "The beginning date can't be older than the end date.");
                            }
                            break;
                        case ALGORITHM2:
//                            createAlert(Alert.AlertType.WARNING, "This algorithm was not created", "Choose another algorithm.");
//                            break;
                        default:
                            createAlert(Alert.AlertType.WARNING, "This algorithm was not created", "Choose another algorithm.");
                            break;
                    }
                }
            }
        } catch (NumberFormatException e) {
            createAlert(Alert.AlertType.WARNING, "Wrong date format", "The dates don't have the appropriate format (D/M/A).");
        }

    }

    @FXML
    void showGraphic(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Statistics.fxml"));
            root = loader.load();
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exit(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LabcMenu.fxml"));
            root = loader.load();
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void createAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
