package app.ui;

import app.controller.TestFileController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TestFileController2 implements Initializable {
    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;

    TestFileController tfc = new TestFileController();

    @FXML
    TextField fileCSV;

    @FXML
    TextField testCount;

    public TestFileController2() throws IOException, ClassNotFoundException {
        // this is a constructor empty
    }

    @FXML
    void getTestLine(ActionEvent event) {
        String file = fileCSV.getText();
        boolean fileValid = true;
        int ts = 0;
        int tsN = 0;

        do {
            boolean test = true;
            try {
                if (!tfc.getTestLine(file, ts))
                    fileValid = false;

            } catch (IllegalArgumentException e) {
                out.println("File not found");
            }

            if (fileValid) {
                ts++;

                //Checks the NHS Code
                try {
                    tfc.validCode();
                } catch (IllegalArgumentException e) {
                    test = false;
                    tsN++;
                    alertInvalidAttribute(ts);
                }

                //Checks the lab
                if(test){
                    try{
                        tfc.validLab();
                    }catch (IllegalArgumentException e){
                        test = false;
                        tsN++;
                        alertInvalidAttribute(ts);
                    }
                }


                //Check the client
                 if(test) {
                    try {
                        tfc.validClient();
                    } catch (IllegalArgumentException | IOException e) {
                        test = false;
                        tsN++;
                        alertInvalidAttribute(ts);
                    }
                }

                //Checks the TestType
                if(test) {
                    try {
                        tfc.validTestType();
                    } catch (IllegalArgumentException e) {
                        test = false;
                        tsN++;
                        alertInvalidAttribute(ts);
                    }
                }

                //Checks the Category
                if(test) {
                    try {
                        tfc.validCategory();
                    } catch (IllegalArgumentException e) {
                        test = false;
                        tsN++;
                        alertInvalidAttribute(ts);
                    }
                }

                //Checks the Parameters
                if(test) {
                    try {
                        tfc.validParameter();
                    } catch (IllegalArgumentException | IOException e) {
                        test = false;
                        tsN++;
                        alertInvalidAttribute(ts);
                    }
                }

                //Checks the Dates
                if(test) {
                    try {
                        tfc.validDateTime();
                    } catch (IllegalArgumentException e) {
                        test = false;
                        tsN++;
                        alertInvalidAttribute(ts);
                    }
                }

                //Adds the test if it is valid
                if (test) {
                    tfc.addCreatedTest();
                    testCount.setText(String.valueOf(ts - tsN));
                }

            }
        } while (fileValid);
        alertTestsAdded(ts - tsN);
    }

    @FXML
    void exit (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LabcMenu.fxml"));
        root = loader.load();

        LabcMenu labcMenu = loader.getController();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            // this is a constructor empty
    }

    void alertInvalidAttribute(int ts) {
        String error = String.format("Test %d will not be loaded because it has invalid attributes", ts);
        Alert alert = new Alert(Alert.AlertType.WARNING, error);
        alert.showAndWait();
    }

    void alertTestsAdded(int ts) {
        String operationSuccess = String.format("%d tests were loaded in the system", ts);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, operationSuccess);
        alert.showAndWait();
    }
}

