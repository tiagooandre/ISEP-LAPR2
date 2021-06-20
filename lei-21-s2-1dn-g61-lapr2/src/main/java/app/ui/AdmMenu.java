package app.ui;

import app.ui.console.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdmMenu {
    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;



    @FXML
    void registerE(ActionEvent event) {
        RegisterEmployeeUI re = new RegisterEmployeeUI();
        re.run();
    }

    @FXML
    void sendR(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/US18.fxml"));
        root = loader.load();

        US18Controller us18 = loader.getController();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void registerL(ActionEvent event) {
        RegiterClinicalAnalysisLaboratoryUI rl = new RegiterClinicalAnalysisLaboratoryUI();
        rl.run();
    }

    @FXML
    void registerT(ActionEvent event) {
        CreateTestTypeUI rt = new CreateTestTypeUI();
        rt.run();
    }

    @FXML
    void registerPC(ActionEvent event) {
        CreateParameterCategoryUI cp = new CreateParameterCategoryUI();
        cp.run();
    }

    @FXML
    void registerP(ActionEvent event) {
        CreateParameterUI p = new CreateParameterUI();
        p.run();
    }


    @FXML
    void exit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        root = loader.load();

        FXMLController mainMenu = loader.getController();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
